package com.example.safecity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class IncidentAdapter extends RecyclerView.Adapter<IncidentAdapter.IncidentViewHolder> {

    private final List<IncidentModel> incidentModelList;

    public IncidentAdapter(List<IncidentModel> incidentModelList) {
        this.incidentModelList = incidentModelList;
    }

    @NonNull
    @Override
    public IncidentAdapter.IncidentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.incident_data_layout, parent, false);
        return new IncidentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final IncidentAdapter.IncidentViewHolder holder, final int position) {
        String type = incidentModelList.get(position).getIncidentType();
        String desc = incidentModelList.get(position).getIncidentDesc();
        String date = incidentModelList.get(position).getIncidentDate();
        String st = incidentModelList.get(position).getIncidentST();
        String src = incidentModelList.get(position).getIncidentSrc();

        holder.setInc_type(type);
        holder.setInc_date(date);
        holder.setInc_desc(desc);
        holder.setInc_st(st);
        holder.setInc_src(src);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return incidentModelList.size();
    }

    public class IncidentViewHolder extends RecyclerView.ViewHolder {
        TextView inc_desc, inc_type, inc_date, inc_st, inc_src;
        public IncidentViewHolder(@NonNull final View itemView) {
            super(itemView);
            inc_desc = itemView.findViewById(R.id.incident_desc);
            inc_type = itemView.findViewById(R.id.incident_type);
            inc_date = itemView.findViewById(R.id.incident_date);
            inc_st = itemView.findViewById(R.id.incident_safety_tip);
            inc_src = itemView.findViewById(R.id.incident_src);
        }

        public void setInc_desc(String strDesc) {
            inc_desc.setText("Description: " + strDesc);
        }

        public void setInc_type(String strType) {
            inc_type.setText(strType);
        }

        public void setInc_date(String strDate) {
            inc_date.setText(strDate);
        }

        public void setInc_st(String strST) {
           inc_st.setText("Safety Tip: " + strST);
        }

        public void setInc_src(String strSRC) {
            inc_src.setText("Source: " + strSRC);
        }
    }
}

