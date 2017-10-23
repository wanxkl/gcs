package com.learning.gcs.common.entity;

import javax.persistence.*;

@Entity
@Table(name = "VpnConfig")
@NamedQuery(name ="VpnConfig",query = "select a from VpnConfig a")
public class VpnConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable =false,unique = true,columnDefinition = "int(16) COMMENT 'vpnID'")
    private int id;
    @Column(nullable = false,columnDefinition = "int(16) COMMENT 'vpn使用期限'")
    private int outTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOutTime() {
        return outTime;
    }

    public void setOutTime(int outTime) {
        this.outTime = outTime;
    }
}
