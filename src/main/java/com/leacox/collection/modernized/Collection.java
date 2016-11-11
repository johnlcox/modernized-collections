package com.leacox.collection.modernized;

import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;

/**
 * @author John Leacox
 */
public interface Collection<E> extends Iterable<E> {
  int size();

  @SuppressWarnings("unchecked")
  default E[] toArray() {
    Class<E> clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    E[] array = (E[]) Array.newInstance(clazz, size());

    int index = 0;
    for (E item : this) {
      array[index] = item;
      index++;
    }

    return array;
  }
}
