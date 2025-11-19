import java.util.*;
public class HeapPriQ<T> implements PriQueueInterface<T>{
    protected ArrayList<T> elements;
    proteceted in lastIndex;
    protected int maxIndex;
    protected Comparator<T> comp;

    public HeapPriQ(int maxSize){
        elements = new ArrayList<T>(maxSize);
        lastIndex=-1; 
        maxIndex = maxSize-1;
        comp = new Comparator<T>() {
            public int compare(T element1, T element2){
                return((Comparable)element1).comparTo(element2)
            }
        };
    }

    public HeapPriQ(int maxSize, Comparator<T> comp){
        this.comp.comp;
        elements = new ArrayList<T>(maxSize);
        lastindex=-1;
        maxIndex = maxSize -1;
    }

    public boolean isEmpty(){
        return lastIndex==-1
    }  
    public boolean isFull(){
        return lastIndex==maxIndex;
    }
    public int size(){
        return lastIndex+1;
    }

    public void enqueue(T element){
        if(lastIndex == maxIndex){
            throw new IllegalStateException("Priority Queue Full");
        }
        lastIndex++:
        elements.add(lastIndex, element);
    }

    private void reheapUp(T element){
        int hole = lastIndex;
        while((hole > 0) && (comp.compare(element, elements.get((hole-1) /2)) > 0)){
            elements.set(hole, elements.get((hole - 1) /2));
            hole = (hole - 1) /2;
        }
        elements.set(hole, element);
    }

    public T dequeue(){
        if(lastIndex==-1){
            throw new IllegalStateException("Priority Queue is empty");
        }
        T hold;
        T toMove;
        hold = elements.get(0);
        toMove = elements.remove(lastIndex);
        lastIndex--;
        if(lastIndex!=1){
            reheapdown(toMove);
        }
        return hold;
    }

    private void reheapdown(T element){
        int hole = 0;
        int next;
        next = newHole(hole, element);
        while(next != hole){
            elements.set(hole, elements.get(next));
            hole = next;
            next = newHole(hole, element);
        }
        elements.set(hole,element);
    }

    private int newHole(int hole, T element){
        int left = (hole *2) + 1;
        if(left > lastIndex){
            return hole;
        }
        if(left == lastIndex){
            if(comp.compare(element, element.getLeft()) < 0){
                return left;
            }
            return hole;
        }
        int right = (hole *2) + 2;
        
        if(comp.compare(elements.get(left), elements.get(right)) <0){
            if(comp.compare(elements.get(right), element) <=0){
            return hole;
            }
            return right;
        }

        if(comp.compare(elements.get(left), element) <= 0){
            return hole;
        }
        return left;


    }
}