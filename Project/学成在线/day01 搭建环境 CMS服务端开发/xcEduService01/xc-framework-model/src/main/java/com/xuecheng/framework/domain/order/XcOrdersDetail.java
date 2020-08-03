package com.xuecheng.framework.domain.order;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by admin on 2018/2/10.
 */
@Data
@ToString
@Entity
@Table(name="xc_orders_detail")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class XcOrdersDetail implements Serializable {
    private static final long serialVersionUID = -916357210051689789L;
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String id;
    @Column(name = "order_number")
    private String orderNumber;
    @Column(name = "item_id")
    private String itemId;
    @Column(name = "item_num")
    private Integer itemNum;
    @Column(name = "item_price")
    private Float itemPrice;
    private String valid;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
}
