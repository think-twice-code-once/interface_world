package com.thinktwicecodeonce.interfacelife;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * -> Created by ThinkTwiceCodeOnce on 23-04-17.
 */

public class OptionsDialog extends DialogFragment {

    private OnSelectListener onSelectListener;

    public void setOnSelectListener(OnSelectListener onSelectListener) {
        this.onSelectListener = onSelectListener;
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
        View contentView = inflater.inflate(R.layout.dialog_options, container, false);
        Button btnEdit = (Button) contentView.findViewById(R.id.dialog_options_btn_edit);
        Button btnDelete = (Button) contentView.findViewById(R.id.dialog_options_btn_delete);
        Button btnCancel = (Button) contentView.findViewById(R.id.dialog_options_btn_cancel);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call back here:
                if (onSelectListener != null) {
                    onSelectListener.onEdit();
                }
                dismiss();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConfirmDeleteDialog confirmDeleteDialog = new ConfirmDeleteDialog();
                confirmDeleteDialog.show(getFragmentManager(),
                        ConfirmDeleteDialog.class.getSimpleName());
                confirmDeleteDialog.setOnConfirmDeleteListener(new OnConfirmDeleteListener() {
                    @Override
                    public void onDelete() {
                        if (onSelectListener != null) {
                            onSelectListener.onDelete();
                        }
                    }

                    @Override
                    public void onCancel() {
                        if (onSelectListener != null) {
                            onSelectListener.onCancel();
                        }
                    }
                });

                dismiss();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onSelectListener != null) {
                    onSelectListener.onCancel();
                }
                dismiss();
            }
        });

        //handle click events:

        return contentView;
    }
}
