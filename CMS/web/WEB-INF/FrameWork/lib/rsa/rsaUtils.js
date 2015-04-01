/**
 * User: jiangq
 * Date: 2015/3/27
 * Time: 14:52
 * Description:
 * 修改基于dave@ohdave.com的rsa.js
 * 修改padding方式默认为PKCS1Padding
 * 修改加密算法进制，可设置进制
 * 暂不支持分组加密
 * TODO 增加分组加密解密算法
 * @param encryptionExponent 加密的公钥指数
 * @param modulus 公钥模
 * @param keylen 公钥模长
 * @param radix 进制
 * @constructor
 */
function RSAKeyPair(encryptionExponent, modulus, keylen, radix) {

    this.e = biFromString(encryptionExponent, radix);

    this.m = biFromString(modulus, radix);
    this.chunkSize = keylen / 8;
    this.radix = radix || 10;
    this.barrett = new BarrettMu(this.m);
}
/**
 *
 * @param key
 * @param s
 * @returns {string}
 */
function encryptedString(key, s) {
    var a = new Array();                    // The usual Alice and Bob stuff
    var sl = s.length;                      // Plaintext string length
    var i = 0, j = 0, k = 0;                            // The usual Fortran index stuff
    var al = 0;                                 // Array length
    var result = "";                        // Cypthertext result
    var block;                              // Big integer block to encrypt
    var crypt;                              // Big integer result
    var text = "";                               // Text result

    if (sl > (key.chunkSize - 11)) {
        sl = key.chunkSize - 11;
    }

    i = 0;
    j = sl - 1;

    while (i < sl) {
        a[j] = s.charCodeAt(i);
        i++;
        j--;
    }

    j = key.chunkSize - (sl % key.chunkSize);

    while (j > 0) {
        rpad = Math.floor(Math.random() * 256);
        while (!rpad) {
            rpad = Math.floor(Math.random() * 256);
        }
        a[i] = rpad;

        i++;
        j--;
    }

    a[sl] = 0;
    a[key.chunkSize - 2] = 2;
    a[key.chunkSize - 1] = 0;


    al = a.length;

    for (i = 0; i < al; i += key.chunkSize) {

        block = new BigInt();

        j = 0;

        for (k = i; k < (i + key.chunkSize); ++j) {
            block.digits[j] = a[k++];
            block.digits[j] += a[k++] << 8;
        }
        window.console.log(block.digits[129])
        crypt = key.barrett.powMod(block, key.e);
        text = biToString(crypt, key.radix)

        result += text;
    }
//result = (result.substring(0, result.length - 1));
    return result;
}

/*****************************************************************************/

//function decryptedString(key, c) {
//    var blocks = c.split(" ");              // Multiple blocks of cyphertext
//    var b;                                  // The usual Alice and Bob stuff
//    var i, j;                               // The usual Fortran index stuff
//    var bi;                                 // Cyphertext as a big integer
//    var result = "";                        // Plaintext result
//
//    for (i = 0; i < blocks.length; ++i) {
//
//        if (key.radix == 16) {
//            bi = biFromHex(blocks[i]);
//        }
//        else {
//            bi = biFromString(blocks[i], key.radix);
//        }
//
//        b = key.barrett.powMod(bi, key.d);
//
//        for (j = 0; j <= biHighIndex(b); ++j) {
//            result += String.fromCharCode(b.digits[j] & 255, b.digits[j] >> 8);
//        }
//    }
//
//    if (result.charCodeAt(result.length - 1) == 0) {
//        result = result.substring(0, result.length - 1);
//    }
//
//    return (result);
//}