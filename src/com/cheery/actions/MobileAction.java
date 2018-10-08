package com.cheery.actions;

import com.cheery.model.BrandEntity;
import com.cheery.model.MobileEntity;
import com.cheery.service.MobileService;
import com.opensymphony.xwork2.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class MobileAction extends ActionSupport implements ModelDriven<MobileEntity> {

    @Getter
    @Setter
    private int pageNo = 1; //当前页
    @Getter
    @Setter
    private int pageSize = 3;   //页面数据条数
    @Getter
    @Setter
    private int dataCount;  //数据总和
    @Getter
    @Setter
    private int pageCount;  //总页数
    @Getter
    @Setter
    private int listSize; //数组长度
    @Getter
    @Setter
    private String keyStr = ""; //搜索关键字
    @Getter
    @Setter
    private int mobileId; //手机序号

    public MobileAction() throws IOException {
    }

    private MobileService mobileServ;

    public void setMobileServ(MobileService mobileServ) {
        this.mobileServ = mobileServ;
    }

    private MobileEntity mobile;

    @Override
    public MobileEntity getModel() {
        mobile = new MobileEntity();
        return mobile;
    }

    ActionContext ac = ActionContext.getContext();
    Map session = ac.getSession();
    HttpServletResponse response = ServletActionContext.getResponse();
    PrintWriter out = response.getWriter();

    /*获得所有手机分页数据*/
    public String queryAllMobile() throws Exception {
        dataCount = mobileServ.queryMobiles();
        pageCount = dataCount % pageSize == 0 ? dataCount / pageSize : dataCount / pageSize + 1;
        if (pageNo <= 0) {
            pageNo = 1;
        } else if (pageNo >= pageCount) {
            pageNo = pageCount;
        }
        List<MobileEntity> list = mobileServ.queryAllPageMobile(keyStr, pageNo, pageSize);
        if (0 < list.size() && null != list) {
            session.put("mobileList", list);
            session.put("pageCount", pageCount);
            session.put("pageNo", pageNo);
            session.put("dataCount", dataCount);
            session.put("pageData", list.size());
            return Action.SUCCESS;
        } else {
            return Action.ERROR;
        }
    }

    /*删除*/
    public String delMobile() throws Exception {
        if (mobileServ.delMobile(mobile)) {
            out.println("ok");
            return null;
        }
        return Action.ERROR;
    }

    /*根据id查询一条数据*/
    public String queryOneById() throws Exception {
        List<MobileEntity> mobiles = mobileServ.queryOneById(mobile);
        List<BrandEntity> brandList = mobileServ.queryBrands();
        if (null != mobiles) {
            session.put("mobile", mobiles);
            session.put("brands", brandList);
            return Action.SUCCESS;
        } else {
            return Action.ERROR;
        }
    }

    /*修改*/
    public String modifyMobile() throws Exception {
        if (mobileServ.modifyMobileById(mobile)) {
            out.print("ok");
            return null;
        } else {
            return Action.INPUT;
        }
    }

}
