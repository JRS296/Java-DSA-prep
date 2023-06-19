class Program {
  static class DoublyLinkedList {
    public Node head;
    public Node tail;

    public void setHead(Node node) {
      if(head == null) {
        head = tail =  node;
        return;
      }
      remove(node);
      insertBefore(head, node);
    }

    public void setTail(Node node) {
      if(tail == null) {
        head = tail = node;
        return;
      }
      remove(node);
      insertAfter(tail, node);
    }

    public void insertBefore(Node node, Node nodeToInsert) {
      if(node == null) return;
      remove(nodeToInsert);
      
      nodeToInsert.next = node;
      Node temp = node.prev;
      node.prev = nodeToInsert;
      nodeToInsert.prev = temp;

      if(temp != null) temp.next = nodeToInsert;
      if(node == head) head = nodeToInsert;
    }

    public void insertAfter(Node node, Node nodeToInsert) {
      if(node == null) return;
      remove(nodeToInsert);
      
      Node temp = node.next;
      node.next = nodeToInsert;
      nodeToInsert.prev = node;
      nodeToInsert.next = temp;

      if(temp != null) temp.prev = nodeToInsert;
      if(node == tail) tail = nodeToInsert;
    }

    public void insertAtPosition(int position, Node nodeToInsert) {
      Node current = head;
      for(int i=1; i<position; i++) {
        current = current.next;
      }
      if(current!=null) {
        insertBefore(current, nodeToInsert);
      } else {
        setTail(nodeToInsert);
      }
    }

    public void removeNodesWithValue(int value) {
      for(Node i = head; i != null; i=i.next) {
        if(i.value == value) remove(i);
      }
    }

    public void remove(Node node) {
      if(node == head) head = head.next;
      if(node == tail) tail = tail.prev;
      if(node.prev!= null) node.prev.next = node.next;
      if(node.next!=null) node.next.prev = node.prev;
    }

    public boolean containsNodeWithValue(int value) {
      for(Node i = head; i != null; i=i.next) {
        if(i.value == value) return true;
      }
      return false;
    }
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
