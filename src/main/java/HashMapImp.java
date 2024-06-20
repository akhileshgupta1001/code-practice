public class HashMapImp {

    private int capcity;
    private Node[] bucket;

    static class Node{
         String key;
        int value;
        Node next;

        Node(String key, int value){
            this.key=key;
            this.value=value;
        }
    }

    public HashMapImp(int capcity){
        this.capcity=capcity;
        bucket = new Node[capcity];
    }

    public int hash(String key){
        return Math.abs(key.hashCode()) % capcity;
    }
    public void put(String key,int value){
        int idx = hash(key);
        Node node = bucket[idx];
        if(node==null){
            bucket[idx] = new Node(key,value);
        }else{
            Node prev = null;
            while(node !=null){
                if(node.key.equals(key)){
                    node.value=value;
                    return;
                }
                prev = node;
                node=node.next;
            }
            prev.next= new Node(key,value);
        }
    }

    public int get(String key){
        int indx = hash(key);
        Node node = bucket[indx];
        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        HashMapImp hashMap = new HashMapImp(10);
        hashMap.put("key1", 1);
        hashMap.put("key2", 2);
        System.out.println(hashMap.get("key1")); // Output: 1
        System.out.println(hashMap.get("key3")); // Output: -1
        hashMap.put("key2", 1); // Update the value for key2
        System.out.println(hashMap.get("key2")); // Output: 1
    }
}
