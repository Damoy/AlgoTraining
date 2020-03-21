package algos;

public class DoublyLinkedList {
  
  public Node head;
  public Node tail;

  public void setHead(Node node) {
    if (head == null) {
      head = node;
      tail = node;
    } else {
      insertBefore(head, node);
    }
  }

  public void setTail(Node node) {
    if (head == null) {
      setHead(node);
    } else {
      insertAfter(tail, node);
    }
  }

  public void insertBefore(Node node, Node nodeToInsert) {
    // don't want to insert head before itself
    if (nodeToInsert == head && nodeToInsert == tail)
      return;

    // want to remove before insertion
    remove(nodeToInsert);

    nodeToInsert.prev = node.prev;
    nodeToInsert.next = node;

    if (node.prev == null) {
      head = nodeToInsert;
    } else {
      node.prev.next = nodeToInsert;
    }

    node.prev = nodeToInsert;
  }

  public void insertAfter(Node node, Node nodeToInsert) {
    // don't want to insert head before itself
    if (nodeToInsert == head && nodeToInsert == tail)
      return;

    // want to remove before insertion
    remove(nodeToInsert);

    nodeToInsert.prev = node;
    nodeToInsert.next = node.next;

    if (node.next == null) {
      tail = nodeToInsert;
    } else {
      node.next.prev = nodeToInsert;
    }

    node.next = nodeToInsert;
  }

  public void insertAtPosition(int position, Node nodeToInsert) {
    if (position == 1) {
      setHead(nodeToInsert);
    } else {
      Node node = head;

      for (int i = 1; i < position && node != null; ++i) {
        node = node.next;
      }

      if (node != null) {
        insertBefore(node, nodeToInsert);
      } else {
        setTail(nodeToInsert);
      }
    }
  }

  public void removeNodesWithValue(int value) {
    Node node = head;
    while (node != null) {
      Node nodeTmp = node;
      node = node.next;
      if (nodeTmp.value == value) {
        remove(nodeTmp);
      }
    }
  }

  public void remove(Node node) {
    if (node == head) {
      head = head.next;
    }

    if (node == tail) {
      tail = tail.prev;
    }

    removeNode(node);
  }

  public void removeNode(Node node) {
    if (node.prev != null) {
      node.prev.next = node.next;
    }

    if (node.next != null) {
      node.next.prev = node.prev;
    }

    node.prev = null;
    node.next = null;
  }

  public boolean containsNodeWithValue(int value) {
    Node node = head;
    while (node != null && node.value != value) {
      node = node.next;
    }
    return node != null;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node node = head;
    while (node != null) {
      if (node.prev != null) {
        sb.append("<-");
      }
      sb.append(node.value);
      if (node.next != null) {
        sb.append("->");
      }
      node = node.next;
    }
    return sb.toString();
  }

  public static class Node {
    public int value;
    public Node prev;
    public Node next;
  
    public Node(int value) {
      this.value = value;
    }
  
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      if (prev != null) {
        sb.append(prev.value);
        sb.append("<-");
      }
      sb.append(value);
      if (next != null) {
        sb.append("->");
        sb.append(next.value);
      }
      return sb.toString();
    }
  }
  
}