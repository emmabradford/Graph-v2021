/**
 * This LinkedStack object represents a Stack ADT implemented as
 * a LinkedList using the StackInterface.
 * 
 * @author Mr. Bredemeier
 * @version October 7, 2012
 */
public class LinkedStack<T> implements StackInterface<T>
{
    private LLNode<T> top;
    private int size;

    public LinkedStack()
    {
        this.top = null;
        this.size = 0;
    }
    
    // returns the logical size of the stack
    public int size()    
    {
        return size;
    }
    
    // tests if this stack is empty
    public boolean empty()
    {
        return (size == 0);
    }
    
    // looks at the object at the top of this stack
    // without removing it from the stack
    public T peek()
    {
        if (size < 1)
            throw new StackUnderflowException();
        return top.getInfo();
    }
    
    // removes the object at the top of this stack 
    // and returns that object as the value of this function
    public T pop()
    {
        if(size < 1)
            throw new StackUnderflowException();
        T result = peek();
        top = top.getLink();
        size --;
        return result;
    }
    
    // pushes an item onto the top of this stack
    public T push(T item)
    {
        LLNode<T> newNode = new LLNode<T>(item);
        newNode.setLink(top);
        top = newNode;
        size ++;
        return item;
    }
    
    // removes all of the elements from this stack
    public void clear()
    {
        top = null;
        size = 0;
    }
    
    // returns the 1 based position where an object is on this stack
    // note: when the method ends, the stack is the same as it was at the start
    @SuppressWarnings("unchecked")
    public int search(Object o)
    {
        boolean found = false;
        int index = 1;
        T value = (T) o;
        LinkedStack<T> temp = new LinkedStack<T>();
        // empty the stack, looking for the object
        while(!empty())
        {
            if(peek().equals(value))
                found = true;
            temp.push(pop());
            if(!found)
                index ++;
        }
        // put everything back as it was
        while(!temp.empty())
            push(temp.pop());
        if(found)
            return index;
        else
            return -1;
    }
}