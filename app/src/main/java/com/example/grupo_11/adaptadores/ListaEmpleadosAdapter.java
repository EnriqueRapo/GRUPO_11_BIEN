package com.example.grupo_11.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grupo_11.R;
import com.example.grupo_11.entidades.Empleados;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ListaEmpleadosAdapter extends RecyclerView.Adapter<ListaEmpleadosAdapter.EmpleadoViewHolder> {

    ArrayList<Empleados> listaEmpleados;
    ArrayList<Empleados> listaOriginal;

    public  ListaEmpleadosAdapter(ArrayList<Empleados> listaEmpleados){
        this.listaEmpleados = listaEmpleados;
        listaOriginal =new ArrayList<>();
        listaOriginal.addAll(listaEmpleados);
    }

    @NonNull
    @Override
    public EmpleadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_empleados, null, false);
        return new EmpleadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmpleadoViewHolder holder, int position) {

        holder.viewNombre.setText(listaEmpleados.get(position).getNombre());
        holder.viewApellidos.setText(listaEmpleados.get(position).getApellidos());
        holder.viewDepartamento.setText(listaEmpleados.get(position).getDepartamento());


    }

    public void filtrado (String txtBuscar){

        int longitud = txtBuscar.length();
        if (longitud==0){
            listaEmpleados.clear();
            listaEmpleados.addAll(listaOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Empleados> collecion = listaEmpleados.stream()
                        .filter(i -> i.getNombre().toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());
                listaEmpleados.clear();;
                listaEmpleados.addAll(collecion);
            }else {
                for (Empleados e: listaOriginal){
                    if (e.getNombre().toLowerCase().contains(txtBuscar.toLowerCase())){
                        listaEmpleados.add(e);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
       return listaEmpleados.size();
    }

    public class EmpleadoViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewApellidos, viewDepartamento;
        public EmpleadoViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewApellidos = itemView.findViewById(R.id.viewApellidos);
            viewDepartamento = itemView.findViewById(R.id.viewDepartamento);
        }
    }
}
