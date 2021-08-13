import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class Mark {

	int scores[] = { 89, 70, 35, 40 };

	public int lengthMethod() {
		return scores.length;
	}

	public int[] SortMethod() {
		Arrays.sort(scores);
		return scores;
	}

	public List<Integer> linkedListMethod() {
		List<Integer> scoreLinkedList = new LinkedList<Integer>();
		scoreLinkedList.add(50);
		// if the element is added successfully,it returns true otherwise returns false
		scoreLinkedList.add(45);
		scoreLinkedList.add(45); // allows duplicate value
		scoreLinkedList.add(92);
		scoreLinkedList.add(30);
		Collections.replaceAll(scoreLinkedList, 50, 51);
		// if the element is replaced successfully ,it returns true otherwise false
		scoreLinkedList.remove(1); // returns and removes the element at specified index
		scoreLinkedList.size(); // returns size of the list (4)
		scoreLinkedList.contains(43); // false
		scoreLinkedList.get(3); // returns 30
		Collections.sort(scoreLinkedList); // sorts the list
		return scoreLinkedList;
	}

	public List<Integer> arrayListMethod() {
		List<Integer> scoreArrayList = new ArrayList<Integer>(5); // here we can initialize capacity
		scoreArrayList.add(50);
		scoreArrayList.add(45);
		// if the element added successfully,it returns true otherwise returns false
		scoreArrayList.add(45); // allows duplicate value
		scoreArrayList.add(92);
		scoreArrayList.add(30);
		Collections.replaceAll(scoreArrayList, 50, 51);
		// if the replacement done successfully,it returns true otherwise returns false
		scoreArrayList.remove(1); // returns and removes the element at specified index
		scoreArrayList.size(); // returns size of the list (4)
		scoreArrayList.contains(43); // false
		scoreArrayList.get(3); // returns 30
		Collections.sort(scoreArrayList); // sorts the list
		return scoreArrayList;
	}

	public Set<Integer> hashSetMethod() { // maintains elements in the order of hash table
		Set<Integer> scoreHashSet = new HashSet<Integer>();
		scoreHashSet.add(50);
		// add the given value and returns true if insertion is successful orelse false
		scoreHashSet.add(45);
		scoreHashSet.add(92);
		scoreHashSet.add(30);
		scoreHashSet.add(81);
		scoreHashSet.add(81); // returns false and ignores duplicate values.
		scoreHashSet.remove(45); // returns true and remove the given element
		scoreHashSet.size(); // return 4
		scoreHashSet.contains(42); // false
		return scoreHashSet;
	}

	public Set<Integer> linkedHashSetMethod() { // maintains insertion order
		Set<Integer> scoreLinkedHashSet = new LinkedHashSet<Integer>();
		scoreLinkedHashSet.add(50);
		scoreLinkedHashSet.add(45);
		scoreLinkedHashSet.add(92);
		scoreLinkedHashSet.add(30);
		scoreLinkedHashSet.add(81);
		scoreLinkedHashSet.add(81); // ignores duplicate values.
		scoreLinkedHashSet.remove(45); // returns true and remove the given element
		scoreLinkedHashSet.size(); // return 4
		scoreLinkedHashSet.contains(42); // false
		return scoreLinkedHashSet;
	}

	public Set<Integer> treeSetMethod() { // insert elements in sorted way(ascending order)
		Set<Integer> scoreTreeSet = new LinkedHashSet<Integer>();
		scoreTreeSet.add(50);
		scoreTreeSet.add(45);
		scoreTreeSet.add(92);
		scoreTreeSet.add(30);
		scoreTreeSet.add(81);
		scoreTreeSet.add(81); // ignores duplicate values.
		scoreTreeSet.remove(45); // returns true and remove the given element
		scoreTreeSet.size(); // return 4
		scoreTreeSet.contains(42); // false
		return scoreTreeSet;
	}

	public Map<Integer, Integer> hashMapMethod() {
		Map<Integer, Integer> scoreHashMap = new HashMap<Integer, Integer>();
		scoreHashMap.put(5, 80);
		scoreHashMap.put(1, 59); // returns null if insertion is sucessful
		scoreHashMap.put(3, null); // null is allowed
		scoreHashMap.put(2, 59); // it allows duplicate values but not duplicate keys
		scoreHashMap.remove(3); // returns true and remove the element at specified key
		scoreHashMap.replace(1, 59, 39); // returs true
		scoreHashMap.get(2); // returns 98
		scoreHashMap.containsKey(3); // false
		scoreHashMap.containsValue(72); // true
		return scoreHashMap;
	}

	public Map<Integer, Integer> linkedHashMapMethod() { // maintains insertion order
		Map<Integer, Integer> scoreLinkedHashMap = new LinkedHashMap<Integer, Integer>();
		scoreLinkedHashMap.put(5, 72);
		scoreLinkedHashMap.put(1, 59); // returns null if insertion is sucessful
		scoreLinkedHashMap.put(3, null); // null is allowed
		scoreLinkedHashMap.put(2, 59); // it allows duplicate values but not duplicate keys
		scoreLinkedHashMap.remove(3); // returns true and remove the element at specified key
		scoreLinkedHashMap.replace(1, 59, 39); // returs true
		scoreLinkedHashMap.get(2); // returns 98
		scoreLinkedHashMap.containsKey(3); // false
		scoreLinkedHashMap.containsValue(72); // true
		return scoreLinkedHashMap;
	}

	public Map<Integer, Integer> treeMapMethod() { // maintains values in sorting order(ascending)
		Map<Integer, Integer> scoreTreeMap = new TreeMap<Integer, Integer>();
		// scoreTreeMap.put(null, 72); //error => null values are not allowed
		scoreTreeMap.put(1, 59); // returns null if insertion is sucessful
		scoreTreeMap.put(3, 48);
		scoreTreeMap.put(2, 59); // it allows duplicate values but not duplicate keys
		scoreTreeMap.remove(3); // returns true and remove the element at specified key
		scoreTreeMap.replace(1, 59, 39); // returs true
		scoreTreeMap.get(2); // returns 98
		scoreTreeMap.containsKey(3); // false
		scoreTreeMap.containsValue(72); // true
		return scoreTreeMap;
	}

	public Queue<Integer> priorityQueueMethod() {
		Queue<Integer> scorePriorityQueue = new PriorityQueue<Integer>();
		scorePriorityQueue.add(32); // returns true if insertion is successful
		scorePriorityQueue.offer(73);
		scorePriorityQueue.add(98);
		scorePriorityQueue.add(52);
		scorePriorityQueue.peek(); // element() //returns first element(32)
		scorePriorityQueue.remove(); // poll() //returns and remove first element
		return scorePriorityQueue;
	}

	public Queue<Integer> arrayDequeMethod() {
		Deque<Integer> scoreDeque = new ArrayDeque<Integer>();
		scoreDeque.add(32);
		scoreDeque.offer(73);
		scoreDeque.addFirst(98);
		scoreDeque.addLast(52); // add element at last
		scoreDeque.peek(); // element() //returns first element(32)
		scoreDeque.removeFirst(); // poll() //remove first element
		scoreDeque.removeLast(); // remove element at last
		return scoreDeque;
	}

	public static void main(String[] args) {
		Mark mark = new Mark();
		System.out.println("Iteration for LinkedList");
		Iterator<Integer> linkedListIterator = mark.linkedListMethod().iterator();
		while (linkedListIterator.hasNext()) {
			System.out.println(linkedListIterator.next());
		}

		System.out.println("Iteration for ArrayList");

		for (Integer scores : mark.arrayListMethod()) {
			System.out.println(scores);
		}

		System.out.println("Iteration for HashSet");

		Iterator<Integer> hashSetIterator = mark.hashSetMethod().iterator();
		while (hashSetIterator.hasNext()) {
			System.out.println(hashSetIterator.next());
		}

		System.out.println("Iteration for LinkedHashSet");

		Iterator<Integer> linkedHashSetIterator = mark.linkedHashSetMethod().iterator();
		while (linkedHashSetIterator.hasNext()) {
			System.out.println(linkedHashSetIterator.next());
		}

		System.out.println("Iteration for TreeSet");

		Iterator<Integer> treeSetIterator = mark.treeSetMethod().iterator();
		while (treeSetIterator.hasNext()) {
			System.out.println(treeSetIterator.next());
		}

		System.out.println("Iteration for HashMap");

		Iterator<Map.Entry<Integer, Integer>> hashMapIterator = mark.hashMapMethod().entrySet().iterator();
		while (hashMapIterator.hasNext()) {
			Map.Entry<Integer, Integer> mapEntry = hashMapIterator.next();
			System.out.println("key : " + mapEntry.getKey() + " value: " + mapEntry.getValue());
		}

		System.out.println("Iteration for LinkedHashMap");

		Iterator<Map.Entry<Integer, Integer>> linkedHashMapIterator = mark.linkedHashMapMethod().entrySet().iterator();
		while (linkedHashMapIterator.hasNext()) {
			Map.Entry<Integer, Integer> mapEntry = linkedHashMapIterator.next();
			System.out.println("key : " + mapEntry.getKey() + " value: " + mapEntry.getValue());
		}

		System.out.println("Iteration for TreeMap");

		Iterator<Map.Entry<Integer, Integer>> treeMapIterator = mark.treeMapMethod().entrySet().iterator();
		while (treeMapIterator.hasNext()) {
			Map.Entry<Integer, Integer> mapEntry = treeMapIterator.next();
			System.out.println("key : " + mapEntry.getKey() + " value: " + mapEntry.getValue());
		}

		System.out.println("Iteration for PriorityQueue");

		for (Integer scores : mark.priorityQueueMethod()) {
			System.out.println(scores);
		}

		System.out.println("Iteration for ArrayDeque");

		for (Integer scores : mark.arrayDequeMethod()) {
			System.out.println(scores);
		}

		System.out.println("Iteration for forEach");

		for(Map.Entry<Integer,Integer> scores: mark.hashMapMethod().entrySet()){
		System.out.println("key :"+scores.getKey()+" value:"+scores.getValue());
		}
	}
}
