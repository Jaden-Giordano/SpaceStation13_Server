package org.psigames.ssserver.tools;

import java.io.*;

/**
 * Created by Jaden on 9/12/2015.
 */
public class SerializableUtil {

    /**
     * Serialize a class implementing {@link java.io.Serializable}
     * @param obj
     * @return byte array containing data for serialized objects
     * @throws IOException
     */
    public static byte[] serialize(Serializable obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }

    /**
     * De-serializes an object with given array of bytes
     * @param bytes to deserialize
     * @return De-serialized object
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Serializable deserialize(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return (Serializable) o.readObject();
    }

}
