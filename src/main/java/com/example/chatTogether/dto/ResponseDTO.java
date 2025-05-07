package com.example.chatTogether.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class ResponseDTO<T> implements Serializable {

    private MetaDTO meta;
    private T data;

    @JsonProperty("meta")
    public MetaDTO getMetaDTO() {
        return meta;
    }

    public void setMetaDTO(MetaDTO meta) {
        this.meta = meta;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResponseDTO<?> that = (ResponseDTO<?>) o;

        if (!Objects.equals(meta, that.meta)) return false;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = meta != null ? meta.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "meta=" + meta +
                ", data=" + data +
                '}';
    }
}
