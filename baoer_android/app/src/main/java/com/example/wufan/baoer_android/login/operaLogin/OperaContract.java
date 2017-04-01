package com.example.wufan.baoer_android.login.operaLogin;


import com.example.wufan.baoer_android.BasePresenter;
import com.example.wufan.baoer_android.BaseView;

/**
 * 本类用于定义好View层与Presenter层各自需要实现的方法
 * <p>
 * 本接口的设计目的在于 核对需求、理清思路、转移维护人员、测试团队进行分层测试、项目模块复用
 * <p>
 * 核对需求：当拿到设计师的设计稿后，编程者开始根据页面需要显示的内容，在View接口进行函数命名。涉及到数据请求和存取的，在Presenter接口进行函数命名
 * 理清思路：编程人员是否能够根据本接口的方法，使用UML语言画出流程图并配上本接口的函数名？有些步骤分拆开来，成为独立的函数，是否能提高复用率？
 * 转移维护人员：当本模块的代码转移至其它人维护时，负责接手的同事首先阅读本接口，从整体上了解整个模块的函数名。不明白的函数名最好问清楚上一任的维护者。
 * 测试团队测试：测试人员通过阅读本接口，实现提高测试覆盖率。但无论怎样，重要的函数必需优先进行覆盖！
 * 项目模块复用：如果新项目需要减少或者增加功能，先编辑本接口。本接口编辑完成，IDE会提示实现的Class是否多出或者缺少相应的实现函数，提高开发效率。
 */
public interface OperaContract {

    interface View extends BaseView<Presenter> {

        void showLogin();//显示登录页面

        void showPhoneLogin();//显示手机登录

        void showWechatLogin();//显示微信登录

        void showMircroBlogLogin();//显示微博登录

        void showQQLogin();//显示QQ登录

        void showInvitationCodeIllustrate();//显示邀请码说明

        void showError(String errorType);//显示错误提示

    }

    interface Presenter extends BasePresenter {

        void checkInvitationIllustrate(String invitationCode);//检查邀请码

        void doPhoneLogin();//手机登录

        void doWechatLogin();//微信登录

        void doMircroBlogLogin();//微博登录

        void doQQLogin();//QQ登录

    }
}
