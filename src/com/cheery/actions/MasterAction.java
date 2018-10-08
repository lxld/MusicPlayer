package com.cheery.actions;

import com.cheery.model.MasterEntity;
import com.cheery.service.MasterService;
import com.opensymphony.xwork2.*;
import java.util.Map;

public class MasterAction extends ActionSupport implements ModelDriven<MasterEntity> {
    private MasterService masterServ;

    public void setMasterServ(MasterService masterServ) {
        this.masterServ = masterServ;
    }

    private MasterEntity master;

    @Override
    public MasterEntity getModel() {
        master = new MasterEntity();
        return master;
    }

    ActionContext ac = ActionContext.getContext();
    Map session = ac.getSession();

    public String login() throws Exception {
        if (masterServ.masterLogin(master)) {
            return Action.SUCCESS;
        } else {
            session.put("tips", "账户名或密码错误~")
            return Action.INPUT;
        }
    }

}
