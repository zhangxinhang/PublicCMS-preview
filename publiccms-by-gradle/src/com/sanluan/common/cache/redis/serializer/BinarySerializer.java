package com.sanluan.common.cache.redis.serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sanluan.common.base.Base;

/**
 * @author zhangxdr
 *
 * @param <T>
 */
public class BinarySerializer<T> extends Base implements RedisSerializer<T> {
    public byte[] serialize(String str) {
        return null == str ? EMPTY_BYTES : str.getBytes(DEFAULT_CHARSET);
    }

    @Override
    public byte[] serialize(final T graph) {
        if (empty(graph)) {
            return EMPTY_BYTES;
        }
        try (ByteArrayOutputStream os = new ByteArrayOutputStream(); ObjectOutputStream oos = new ObjectOutputStream(os);) {
            oos.writeObject(graph);
            oos.flush();
            return os.toByteArray();
        } catch (Exception e) {
            log.warn("Fail to serializer graph. graph=" + graph, e);
            return EMPTY_BYTES;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public T deserialize(final byte[] bytes) {
        if (empty(bytes)) {
            return null;
        }
        try (ByteArrayInputStream is = new ByteArrayInputStream(bytes); ObjectInputStream ois = new ObjectInputStream(is);) {
            return (T) ois.readObject();
        } catch (Exception e) {
            log.warn("Fail to deserialize bytes.", e);
            return null;
        }
    }
}