package com.masterspring.common.demo.io.inandoutstream;


import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by lihuiyan on 2015/5/22.
 */
public class ObjectStreamTest {

    private static final String TMP_FILE = "bom.tmp";

    private static void testWrite() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(TMP_FILE));
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeByte((byte) 65);
            objectOutputStream.writeChar('A');
            objectOutputStream.writeDouble(1.4222D);
            objectOutputStream.writeFloat(3.14f);
            objectOutputStream.writeInt(10);
            HashMap hashMap = new HashMap();
            hashMap.put("one", "one");
            hashMap.put("two", "two");
            objectOutputStream.writeObject(hashMap);
            objectOutputStream.writeObject(new ObjectA("1", "aa"));
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void testRead() {
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(TMP_FILE));
            boolean b = o.readBoolean();
            byte bb = o.readByte();
            char c = o.readChar();
            Double d = o.readDouble();
            Float f = o.readFloat();
            Integer i = o.readInt();
            try {
                Map map = (HashMap) o.readObject();
                Iterator iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();

                    entry.getValue();
                    System.out.println("Map.Entry:" + entry.getKey() + "--" + entry.getValue());
                }

                ObjectA objectA = (ObjectA) o.readObject();
                System.out.println("boolean:" + b);
                System.out.println("byte:" + bb);
                System.out.println("char:" + c);
                System.out.println("double:" + d);
                System.out.println("float:" + f);
                System.out.println("int:" + i);
                System.out.println("objectA:" + objectA);


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        testWrite();
        testRead();
    }
}

class ObjectA implements Serializable {
    private String id;
    private String name;

    public ObjectA(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ObjectA:[" + id + "--" + name + "]";
    }
};