/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ulatina.diariofacil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Diego
 */
public class Orden implements IDescuento {

    private static final String[] COLUMNS = {
        " No. ",
        " Cant. ",
        "     Descripcion     ",
        "   Precio   ",
        " Descu. ",
        " Subtotal "
    };

    private static String[] INFO = {
        "No. Orden: ",
        "Fecha : ",
        "Cliente: ",
        "Cedula: ",
        "Telefono: ",
        "Direccion: ",
        "Responsable: "
    };

    private static final String[] TOTALES = {
        "Subtotal: ",
        "Descuento: ",
        "Impuesto: ",
        "Total: "
    };

    private static final String MSJ = "¡Gracias por preferirnos!";
    private static final String PROMO = "Tiene un descuento acumulado por ser cliente VIP.";

    private int id;
    private Calendar fecha;
    private Usuario usuario;
    private int consItem;
    private List<Item> items = new ArrayList<>();
    private double subtotal;
    private double subDesc;
    private double impuesto;
    private double total;

    public Orden(int numero, Usuario usuario) {
        this.id = numero;
        this.fecha = Calendar.getInstance();
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        String columnNames = formatColumnNames(COLUMNS);
        int l = columnNames.length() - 1;
        String div = getDivider(l);

        sb.append(div);

        String[] info = Arrays.copyOf(INFO, INFO.length);
        info[0] += id;
        info[1] += fecha.get(Calendar.DAY_OF_MONTH) + "/"
                + fecha.get(Calendar.MONTH) + "/"
                + fecha.get(Calendar.YEAR);
        info[2] += usuario.getNombre();
        info[3] += usuario.getCedula();
        info[4] += usuario.getTelefono();
        info[5] += usuario.getDireccion();
        info[6] += usuario.getRep();

        sb.append(formatRowArray(info, l));
        sb.append(div);
        sb.append(columnNames);
        sb.append(div);
        sb.append(formatItems(items));
        sb.append(div);

        String[] totales = Arrays.copyOf(TOTALES, TOTALES.length);
        totales[0] += subDesc;
        totales[1] += getDescuento() * 100 + "%";
        totales[2] += impuesto;
        totales[3] += total;

        sb.append(formatRowArray(totales, l));
        sb.append(div);
        sb.append(formatRow(MSJ, l));
        try {
            getPromo(l);
        } catch (ChiquitinasException e) {
            sb.append(e.getMessage());
        }
        sb.append(div);

        return sb.toString();
    }

    private void getPromo(int l) throws ChiquitinasException {
        if (total > 10000) {
            throw new ChiquitinasException(formatRow(PROMO, l));
        }
    }

    private String formatItems(List<Item> items) {
        StringBuilder sb = new StringBuilder();

        for (Item i : items) {
            String[] rows = new String[COLUMNS.length];
            rows[0] = String.valueOf(i.getNumero());
            rows[1] = String.valueOf(i.getCantidad());
            rows[2] = formatDescripcion(i);
            rows[3] = String.valueOf(i.getProducto().getPrecio());

            double d = i.getProducto().checkDescuento();
            String des = "";
            if (d != 0) {
                des = d * 100 + "%";
            }

            rows[4] = des;
            rows[5] = String.valueOf(i.getCantidad() * i.getProducto().getPrecio());

            sb.append(formatItemRows(rows, COLUMNS));
        }

        return sb.toString();
    }

    private String formatItemRows(String[] rows, String[] columns) {
        for (int j = 0; j < rows.length; j++) {
            int colL = columns[j].length() - 2;
            int rowL = rows[j].length();

            if (colL > rowL) {
                for (int k = rowL; k < colL; k++) {
                    rows[j] = " " + rows[j];
                }
            } else if (colL < rowL) {
                rows[j] = rows[j].substring(0, colL - 2) + "..";
            }
            rows[j] = " " + rows[j] + " ";
        }
        return formatColumnNames(rows);
    }

    private String formatDescripcion(Item i) {
        String desc = i.getProducto().getNombre();

        if (!i.getProducto().getDescripcion().trim().isEmpty()) {
            desc += " (" + i.getProducto().getDescripcion() + ")";
        }

        return desc;
    }

    private String formatColumnNames(String[] names) {
        StringBuilder sb = new StringBuilder();

        sb.append("|");
        for (String s : names) {
            sb.append(s);
            sb.append("|");
        }
        sb.append("\n");

        return sb.toString();
    }

    private String formatRowArray(String[] rows, int l) {
        StringBuilder sb = new StringBuilder();

        for (String s : rows) {
            sb.append(formatRow(s, l));
        }

        return sb.toString();
    }

    private String formatRow(String s, int l) {
        StringBuilder sb = new StringBuilder();

        sb.append("| ");
        sb.append(s);
        for (int i = s.length(); i < l - 3; i++) {
            sb.append(" ");
        }
        sb.append("|\n");

        return sb.toString();
    }

    private String getDivider(int l) {
        StringBuilder sb = new StringBuilder();

        sb.append("+");
        for (int i = 0; i < l - 2; i++) {
            sb.append("-");
        }
        sb.append("+\n");

        return sb.toString();
    }

    public void addItem(Producto p, int cantidad) {
        items.add(new Item(nextConsItem(), p, cantidad));
        subtotal += p.getPrecio() * cantidad;
        updateTotal();
    }

    public void removeItem(int i) {
        subtotal -= items.get(i).getProducto().getPrecio() * items.get(i).getCantidad();
        items.remove(i);
        updateTotal();
    }

    private void updateTotal() {
        subDesc = subtotal - (subtotal * getDescuento());
        impuesto = subDesc * 0.13;
        total = subDesc + impuesto;
    }

    private int nextConsItem() {
        return consItem++;
    }

    public int getId() {
        return id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public double getDescuento() {
        return 0.01;
    }

}
