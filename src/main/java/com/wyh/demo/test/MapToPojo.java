package com.wyh.demo.test;

/**
 * @author imai
 * @since 2022/9/8 2:26 下午
 */
public class MapToPojo {
    private String id;
    private String action;
    private long customerOrderId;

    public String getId() {
        return id;
    }

    @Override public String toString() {
        return "MapToPojo{" + "id='" + id + '\'' + ", action='" + action + '\''
            + ", customerOrderId=" + customerOrderId + '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public long getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(long customerOrderId) {
        this.customerOrderId = customerOrderId;
    }
}
