package com.thinktwicecodeonce.interfacelife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * -> Created by ThinkTwiceCodeOnce on 24-04-17.
 */

public class ConfirmDeleteDialog extends DialogFragment {

    private OnConfirmDeleteListener onConfirmDeleteListener;

    public void setOnConfirmDeleteListener(OnConfirmDeleteListener onConfirmDeleteListener) {
        this.onConfirmDeleteListener = onConfirmDeleteListener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, android.R.style.Theme_Translucent_NoTitleBar);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View contentView = inflater.inflate(R.layout.dialog_confirm_delete, container, false);

        Button btnYes = (Button) contentView.findViewById(R.id.dialog_confirm_delete_btn_yes);
        Button btnCancel = (Button) contentView.findViewById(R.id.dialog_confirm_delete_btn_cancel);

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onConfirmDeleteListener != null) {
                    onConfirmDeleteListener.onDelete();
                }
                dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onConfirmDeleteListener != null) {
                    onConfirmDeleteListener.onCancel();
                }
                dismiss();
            }
        });
        return contentView;
    }
}
