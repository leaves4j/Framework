package com.leaves.framework.common.controller;

/**
 * Created by jiangq on 2015/1/6.
 */
public abstract class AuthorityController implements ICommonController {
    protected CurrentContext CONTEXT;

    public final boolean getNeedLogin() {
        return true;
    }
    public final String getRedirectURL(){
        return "/login";
    }
    public final void setCurrentContext(CurrentContext context) {
        this.CONTEXT = context;
    }
    public final void setLog(String info){

    }
}

