package com.mundipagg.walletdemo.activities;

import android.widget.ListView;

import com.jgabrielfreitas.layoutid.annotations.InjectLayout;
import com.jgabrielfreitas.permissions.core.interfaces.OnPermissionRequest;
import com.jgabrielfreitas.permissions.core.managers.CameraPermissionManager;
import com.karumi.dexter.PermissionToken;
import com.mundipagg.walletdemo.R;
import com.mundipagg.walletdemo.adapters.SimpleListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnItemClick;
import uk.co.ribot.easyadapter.EasyAdapter;

@InjectLayout(layout = R.layout.activity_main)
public class MainActivity extends DemoBaseActivity implements OnPermissionRequest {

    @Bind(R.id.actionsRecyclerView)
    ListView actionsRecyclerView;

    @Override
    protected void modifyViews() {
        super.modifyViews();

        List<String> actions = new ArrayList<>();
        actions.add("Listar cartões");
        actions.add("Criar cartão");
        actions.add("Deletar cartão");
        actionsRecyclerView.setAdapter(new EasyAdapter<>(this, SimpleListAdapter.class, actions));
    }

    @OnItemClick(R.id.actionsRecyclerView)
    public void onActionClicked(int position) {
        switch (position) {
            case 0:
                doIntent(ListCreditCardsActivity.class);
                break;
            case 1:
                new CameraPermissionManager(this, this).requestPermission();
                break;
            case 2:
                doIntent(DeleteActivity.class);
                break;
        }
    }

    @Override
    public void onPermissionAllowed() {
        doIntent(ScanCreditCardActivity.class);
    }

    @Override
    public void onPermissionDenied() {
        toast("NO CAMERA PERMISSION");
    }

    @Override
    public void onPermissionDeniedButAskAgain(PermissionToken permissionToken) {
        toast("ALLOW CAMERA PERMISSION!!");
        permissionToken.continuePermissionRequest();
    }
}
