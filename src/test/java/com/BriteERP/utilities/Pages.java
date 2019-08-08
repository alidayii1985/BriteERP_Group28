package com.BriteERP.utilities;

import com.BriteERP.pages.CrmPage;
import com.BriteERP.pages.ExpensesPage;
import com.BriteERP.pages.HomePage;
import com.BriteERP.pages.LoginPage;

public class Pages {
    private LoginPage loginPage;
    private HomePage homePage;
    private ExpensesPage expensesPage;
    private CrmPage crmPage;



    public LoginPage login(){
        if(loginPage==null){

            loginPage=new LoginPage();
        }

        return loginPage;

    }

    public HomePage homePage(){
        if(homePage==null){

            homePage=new HomePage();
        }

        return homePage;

    }
    public ExpensesPage expensesPage(){
        if(expensesPage==null){

            expensesPage=new ExpensesPage();
        }

        return expensesPage;

    }
    public CrmPage crmPage(){
        if(crmPage==null){

            crmPage=new CrmPage();
        }

        return crmPage;

    }
}
