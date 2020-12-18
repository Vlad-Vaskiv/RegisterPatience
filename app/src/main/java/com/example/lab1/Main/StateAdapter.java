package com.example.lab1.Main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lab1.R;

import java.util.List;
public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private final List<Doctor> doctors;

    StateAdapter(Context context, List<Doctor> doctors) {
        this.doctors = doctors;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateAdapter.ViewHolder holder, int position) {
        Doctor doctor = doctors.get(position);
        holder.fotoView.setImageResource(doctor.getFotoResource());
        holder.nameView.setText(doctor.getName());
        holder.specialtyView.setText(doctor.getSpeciality());
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView fotoView;
        final TextView nameView, specialtyView;
        ViewHolder(View view){
            super(view);
            fotoView = (ImageView)view.findViewById(R.id.foto);
            nameView = (TextView) view.findViewById(R.id.name);
            specialtyView = (TextView) view.findViewById(R.id.specialty);
        }
    }
}
