package vn.com.newsviet.Utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.provider.SyncStateContract;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;



import java.util.Arrays;

import vn.com.newsviet.R;

public class ShowPopup {
    public Dialog popupDialog;
    public Context context;
    public int isAlert = 0;
    public static int positionOffset = 1, positionSeletion = 0;


    public ShowPopup(Context context) {
        this.context = context;
        popupDialog = new Dialog(context);
    }

    // interface
    public interface OnPopupActionListener {
        void onCancel();

        void onAccept();
    }

    public interface OnPopupByLotActionListener {
        void onCancel();

        void onAccept(String smg);
    }

    public interface OnPopupByLotActionListener1 {
        void onCancel();

        void onAccept(String smg, int qty_done, int qty_require);
    }

    public interface OnWheelViewListener {
        void onSelected(int selectedIndex, String item);
    }



    public Dialog info(String info) {
        return info(info, "", null);
    }

    public Dialog info(String info, final OnPopupActionListener listener) {
        return info(info, "", listener);
    }

    public Dialog info(String info, String title) {
        return info(info, title, null);
    }

    public Dialog info(String info, String txtTitle, final OnPopupActionListener listener) {
        int w = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.7f);
        _initPopupDialog(false, R.layout.dialog_info, w);
//        .Constants.noInternetDialog = popupDialog;
        if (isAlert == 1)
            popupDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

        TextView title = (TextView) popupDialog.findViewById(R.id.title);
        title.setText(txtTitle);

        title.setVisibility(txtTitle != null && !txtTitle.equals("") ? View.VISIBLE : View.GONE);

        TextView content = (TextView) popupDialog.findViewById(R.id.content);
        content.setText(info);

        TextView close = (TextView) popupDialog.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onAccept();
                popupDialog.dismiss();
            }
        });

        return popupDialog;
    }


    public Dialog confirm(String info, String txtTitle, String titleaccept, String titleclose, final OnPopupActionListener listener) {
        int w = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.7f);
        _initPopupDialog(false, R.layout.dialog_confirm, w);
//        Constants.noInternetDialog = popupDialog;
        if (isAlert == 1)
            popupDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);

        TextView title = (TextView) popupDialog.findViewById(R.id.title);
        TextView accept = (TextView) popupDialog.findViewById(R.id.accept);
        TextView close = (TextView) popupDialog.findViewById(R.id.close);

        title.setText(txtTitle);
        accept.setText(titleaccept);
        close.setText(titleclose);

        title.setVisibility(txtTitle != null && !txtTitle.equals("") ? View.VISIBLE : View.GONE);

        TextView content = (TextView) popupDialog.findViewById(R.id.content);
        content.setText(info);


        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onCancel();
                popupDialog.dismiss();
            }
        });
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null)
                    listener.onAccept();
                popupDialog.dismiss();
            }
        });

        return popupDialog;
    }



    private void _initPopupDialog(boolean isCancelable, int resID, int w) {
        _initPopupDialog(isCancelable, resID, w, 0);
    }


    private void _initPopupDialog(boolean isCancelable, int resID, int w, int h) {
        if (popupDialog != null)
            popupDialog.dismiss();
        popupDialog = new Dialog(context);
        popupDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        popupDialog.setContentView(resID);
        popupDialog.setCancelable(isCancelable);
        popupDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(popupDialog.getWindow().getAttributes());
        if (w != 0)
            lp.width = w;
        if (h != 0)
            lp.height = h;
        lp.gravity = Gravity.CENTER;
        popupDialog.getWindow().setAttributes(lp);
    }

    public Dialog loading(boolean cancelable) {
        int w = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.7f);
        _initPopupDialog(cancelable, R.layout.dialog_loading, w);

        return popupDialog;
    }

    public Dialog loading_text(boolean cancelable, String content) {
        int w = (int) (context.getResources().getDisplayMetrics().widthPixels * 0.7f);
        _initPopupDialog(cancelable, R.layout.dialog_loading_notext, w);
        TextView title = popupDialog.findViewById(R.id.title);
        title.setText(content);
        title.setVisibility(!content.equals("") ? View.VISIBLE : View.GONE);


        return popupDialog;
    }
}
