package com.masterspring.common.demo.io.serializable;

import java.io.*;

/**
 * Created by lihuiyan on 2015/5/22.
 */
public class ExternalizableTest {
    private static final String TMP_FILE = "serializable.txt";

    public static void main(String[] args) {
        testWrite();
        testRead();
    }

    private static void testWrite() {
        try {
            ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
            ObjectA objectC = new ObjectA("aa", 100);
            oo.writeObject(objectC);
            oo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testRead() {
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(TMP_FILE));
            ObjectA objectc = (ObjectA) oi.readObject();
            System.out.println(objectc);
            oi.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class ObjectA implements Externalizable {
    private String name;
    private int age;

    public ObjectA(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * �������޲ι��캯��
     */
    public ObjectA() {

    }

    /**
     * The object implements the writeExternal method to save its contents
     * by calling the methods of DataOutput for its primitive values or
     * calling the writeObject method of ObjectOutput for objects, strings,
     * and arrays.
     *
     * @param out the stream to write the object to
     * @throws IOException Includes any I/O exceptions that may occur
     * @serialData Overriding methods should use this tag to describe
     * the data layout of this Externalizable object.
     * List the sequence of element types and, if possible,
     * relate the element to a public/protected field and/or
     * method of this Externalizable class.
     */
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeInt(age);
    }

    /**
     * The object implements the readExternal method to restore its
     * contents by calling the methods of DataInput for primitive
     * types and readObject for objects, strings and arrays.  The
     * readExternal method must read the values in the same sequence
     * and with the same types as were written by writeExternal.
     *
     * @param in the stream to read data from in order to restore the object
     * @throws IOException            if I/O errors occur
     * @throws ClassNotFoundException If the class for an object being
     *                                restored cannot be found.
     */
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = in.readInt();
    }

    public String toString() {
        return "ObjectA[" + name + "-" + age + "]";
    }
};