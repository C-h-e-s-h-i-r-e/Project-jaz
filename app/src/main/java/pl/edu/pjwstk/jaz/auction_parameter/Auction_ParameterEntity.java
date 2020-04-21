package pl.edu.pjwstk.jaz.auction_parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "auction_parameter")
public class Auction_ParameterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigInteger number_value;
    private String text_value;
    private Long auciton_id;
    private String parameter_name;

    Auction_ParameterEntity(){super();}

    public Auction_ParameterEntity(BigInteger number_value,String text_value,Long auciton_id,String parameter_name){
        this.number_value=number_value;
        this.text_value=text_value;
        this.auciton_id=auciton_id;
        this.parameter_name=parameter_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getNumber_value() {
        return number_value;
    }

    public void setNumber_value(BigInteger number_value) {
        this.number_value = number_value;
    }

    public String getText_value() {
        return text_value;
    }

    public void setText_value(String text_value) {
        this.text_value = text_value;
    }

    public Long getAuciton_id() {
        return auciton_id;
    }

    public void setAuciton_id(Long auciton_id) {
        this.auciton_id = auciton_id;
    }

    public String getParameter_name() {
        return parameter_name;
    }

    public void setParameter_name(String parameter_name) {
        this.parameter_name = parameter_name;
    }
}
