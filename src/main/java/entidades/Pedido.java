/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.List;
import serializer.ClienteSerializer;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "pedidos")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Pedido {
    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    @JsonSerialize(using = ClienteSerializer.class)
    private Cliente cliente;

    @Column(name = "precio_total")
    private double precioTotal;
    
    @Column(name = "fecha_entrega")
    private Calendar fecha;
    
    @Column(name = "lugar_entrega")
    private String lugarEntrega;
    
    @Column(name = "observaciones")
    private String observaciones;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy="pedido")
    private List<PedidoProducto> pedidosProducto;
        
    @OneToMany(fetch = FetchType.EAGER, cascade ={CascadeType.PERSIST, CascadeType.DETACH}, mappedBy="id")
    private List<Venta> ventas;
    
    public Pedido() {
    }

    public Pedido(Integer id) {
        this.id = id;
    }

    public Pedido(Integer id, double precioTotal, List<PedidoProducto> pedidosProducto, List<Venta> ventas, Cliente cliente) {
        this.id = id;
        this.precioTotal = precioTotal;
        this.pedidosProducto = pedidosProducto;
        this.ventas = ventas;
        this.cliente = cliente;
    }

    public Pedido(double precioTotal, List<PedidoProducto> pedidosProducto, List<Venta> ventas, Cliente cliente) {
        this.precioTotal = precioTotal;
        this.pedidosProducto = pedidosProducto;
        this.ventas = ventas;
        this.cliente = cliente;
    }

    public Pedido(double precioTotal, Cliente cliente) {
        this.precioTotal = precioTotal;
        this.cliente = cliente;
    }

    public Pedido(double precioTotal, Calendar fecha, String lugarEntrega) {
        this.precioTotal = precioTotal;
        this.fecha = fecha;
        this.lugarEntrega = lugarEntrega;
    }
    

    public Integer getId() {
        return id;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<PedidoProducto> getPedidosProducto() {
        return pedidosProducto;
    }

    public void setPedidosProducto(List<PedidoProducto> pedidosProducto) {
        this.pedidosProducto = pedidosProducto;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", precioTotal=" + precioTotal + ", pedidosProducto=" + pedidosProducto + ", ventas=" + ventas + ", cliente=" + cliente + '}';
    }
    

}
