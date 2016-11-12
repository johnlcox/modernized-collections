package com.leacox.collection.modernized;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author John Leacox
 */
public class ModernizedArrayList<E> implements ModernizedCollection<E> {
  private final ArrayList<E> list = new ArrayList<E>();

  public int size() {
    return list.size();
  }

  public Iterator<E> iterator() {
    return list.iterator();
  }

  @SuppressWarnings("unchecked")
  @Override
  public E[] toArray() {
    Class<E> clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass())
        .getActualTypeArguments()[0];
    E[] array = (E[]) Array.newInstance(clazz, size());

    return list.toArray(array);
  }
}
