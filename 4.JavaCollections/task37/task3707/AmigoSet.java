package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

/**
 * Created by Miha on 12.05.2017.
 */
public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<E, Object>();
    }

    public  AmigoSet(Collection<? extends E> collection) {

        map = new HashMap<>(Math.max((int)(collection.size() / 0.75f) + 1, 16));
        addAll(collection);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }


    @Override
    public Iterator iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public boolean remove(Object o) {
        return this.map.remove(o) == PRESENT;
    }

    public boolean contains(Object var1) {
        return this.map.containsKey(var1);
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public Object clone() {
        try {
            AmigoSet var1 = (AmigoSet)super.clone();
            var1.map = (HashMap)this.map.clone();
            return var1;
        } catch (Exception var2) {
            throw new InternalError(var2);
        }
    }

    private void writeObject(ObjectOutputStream var1) throws IOException {
        var1.defaultWriteObject();
//        var1.writeInt(this.map.capacity());
//        var1.writeFloat(this.map.loadFactor());
        var1.writeInt(this.map.size());
        Iterator var2 = this.map.keySet().iterator();

        while(var2.hasNext()) {
            Object var3 = var2.next();
            var1.writeObject(var3);
        }

    }

    private void readObject(ObjectInputStream var1) throws IOException, ClassNotFoundException {
        var1.defaultReadObject();
        int var2 = var1.readInt();
        if(var2 < 0) {
            throw new InvalidObjectException("Illegal capacity: " + var2);
        } else {
            float var3 = var1.readFloat();
            if(var3 > 0.0F && !Float.isNaN(var3)) {
                int var4 = var1.readInt();
                if(var4 < 0) {
                    throw new InvalidObjectException("Illegal size: " + var4);
                } else {
                    var2 = (int)Math.min((float)var4 * Math.min(1.0F / var3, 4.0F), 1.07374182E9F);
                    this.map = (HashMap)(this instanceof Set?new LinkedHashMap(var2, var3):new HashMap(var2, var3));

                    for(int var5 = 0; var5 < var4; ++var5) {
                        Object var6 = var1.readObject();
                        this.map.put((E)var6, PRESENT);
                    }

                }
            } else {
                throw new InvalidObjectException("Illegal load factor: " + var3);
            }
        }
    }
}
