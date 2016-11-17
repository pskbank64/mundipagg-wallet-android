package com.mundipagg.walletdemo;

import com.jgabrielfreitas.permissions.core.application.CorePermissionsApplication;
import com.mundipagg.MundipaggAccount;
import com.mundipagg.MundipaggWallet;

/**
 * Created by JGabrielFreitas on 26/09/16.
 */

public class DemoApplication extends CorePermissionsApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        MundipaggWallet.init(this);
        MundipaggAccount.getInstance().setCustomerId("cus_G2gE9gdipSGalVYJ");
    }
}
