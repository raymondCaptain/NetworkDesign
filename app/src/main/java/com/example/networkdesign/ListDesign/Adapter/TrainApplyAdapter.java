package com.example.networkdesign.ListDesign.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import com.example.networkdesign.ListDesign.Model.TrainApply;
import com.example.networkdesign.R;

public class TrainApplyAdapter extends RecyclerView.Adapter<TrainApplyAdapter.ViewHolder> {

    private List<TrainApply> dataSource;

    public TrainApplyAdapter(List<TrainApply> dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_text_note_info, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        TrainApply trainApply = dataSource.get(i);
        String projectShortName = trainApply.getProjectShortName().equals("NULL") ? "" : " " + trainApply.getProjectShortName();
        String projectName = trainApply.getProject() + projectShortName;
        String projectNatrue = htmlText("(" + trainApply.getTrainNature() + ")", "#cccccc");
        String cellText = projectName + projectNatrue;
        viewHolder.cellTextTextView.setText(Html.fromHtml(cellText));
        viewHolder.infoTextView.setText(trainApply.getStatus());
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView cellTextTextView;
        private TextView infoTextView;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            cellTextTextView = itemView.findViewById(R.id.textTextView);
            infoTextView = itemView.findViewById(R.id.infoTextView);
        }
    }

    private String htmlText(String text, String color) {
        String input = "<font color=" + color + ">" + text + "</font>";
        return input;
    }

}
