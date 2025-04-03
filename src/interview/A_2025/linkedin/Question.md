import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/*
* Implement the following interface.
*
* All methods must run in O(1) time.
  */

interface AllForOne {
/**
* Increment the provided key's frequency value by 1.  Or add the key with the frequency 1 if it's not present.
*
* Note that the actual frequency value of the key is not necessary to expose to the caller; its value is only kept internally for bookkeeping purposes.
  */
  void incrementKey(String key);

/**
* Decrement the provided key's frequency value by 1.  Or remove the key if its frequency is 1.  Do nothing if the key is not present.
*
* Note that the actual frequency value of the key is not necessary to expose to the caller; its value is only kept internally for bookkeeping purposes.
  */
  void decrementKey(String key);

/**
* Get one of the keys with the max frequency, or empty string if there are no keys.
  */
  String getMaxKey();

/**
* Get one of the keys with the min frequency, or empty string if there are no keys.
  */
  String getMinKey();
  }

class AllForOneImpl<String> implements AllForOne, Comparator<String> {

private TreeMap<String, Integer> map = new TreeMap<>();

void incrementKey(String key){
map.put(key, map.getOrDefault(key,0)+1);
}

/**
* Decrement the provided key's frequency value by 1.  Or remove the key if its frequency is 1.  Do nothing if the key is not present.
*
* Note that the actual frequency value of the key is not necessary to expose to the caller; its value is only kept internally for bookkeeping purposes.
  */
  void decrementKey(String key){
  map.put(key, map.getOrDefault(key,0)-1);

    }

/**
* Get one of the keys with the max frequency, or empty string if there are no keys.
  */
  String getMaxKey(){
  return map.lastKey();
  }

/**
* Get one of the keys with the min frequency, or empty string if there are no keys.
  */
  String getMinKey(){
  return map.firstKey();
  }

@Override
public int  compare(String a, String b) {
if(map.get(a) >= map.get(b)) {
return 1;
} else {
return -1;
}
}

}


/* Example sequence
incrementKey("foo"); // void
incrementKey("foo"); // void
incrementKey("foo"); // void
incrementKey("foo"); // void
incrementKey("bar"); // void
incrementKey("bar"); // void
incrementKey("bar"); // void
incrementKey("bar"); // void
getMaxKey(); // "foo" or "bar" can be returned because foo -> 4, and bar -> 4
getMinKey(); // "foo" or "bar" can be returned because foo -> 4, and bar -> 4
decrementKey("foo"); // void
getMaxKey(); // "bar" because foo -> 3, and bar -> 4
getMinKey(); // "foo" because foo -> 3, and bar -> 4
decrementKey("foo"); // void
decrementKey("foo"); // void
decrementKey("foo"); // void
getMaxKey(); // "bar" because foo is not in the structure, and bar -> 4
getMinKey(); // "bar" because foo is not in the structure, and bar -> 4
*/