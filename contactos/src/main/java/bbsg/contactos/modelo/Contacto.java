package bbsg.contactos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idContacto;
    String nombre;
    String celular;
    String email;


    @Override
    public String toString() {
        return "Contacto{" +
                "idContacto=" + idContacto +
                ", nombre='" + nombre + '\'' +
                ", celular='" + celular + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

