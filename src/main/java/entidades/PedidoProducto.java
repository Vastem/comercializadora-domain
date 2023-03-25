/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
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
import serializer.PedidoSerializer;

@Entity
@Table(name = "pedidosproductos")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PedidoProducto {
    @Id
    @Column(name = "id_pedidoProducto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidad")
    private Integer cantidad;
    
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pedido")
    @JsonIdentityReference(alwaysAsId = true)
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public PedidoProducto() {
    }

    public PedidoProducto(Integer id, Integer cantidad, Pedido idPedido, Producto idProducto) {
        this.id = id;
        this.cantidad = cantidad;
        this.pedido = idPedido;
        this.producto = idProducto;
    }

    public PedidoProducto(Integer cantidad, Pedido idPedido, Producto idProducto) {
        this.cantidad = cantidad;
        this.pedido = idPedido;
        this.producto = idProducto;
    }

    public PedidoProducto(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido idPedido) {
        this.pedido = idPedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto idProducto) {
        this.producto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final PedidoProducto other = (PedidoProducto) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "PedidoProducto{" + "id=" + id + ", cantidad=" + cantidad + ", idPedido=" + pedido.getId() + ", idProducto=" + producto + '}';
    }
    
    
}
