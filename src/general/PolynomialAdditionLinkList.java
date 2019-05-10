package general;import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.*;
class Term{
	int coefficent;
	int exponent;
	Term(int coefficent, int exponent){
		this.coefficent=coefficent;
		this.exponent=exponent;
	}
}
public class PolynomialAdditionLinkList{
	LinkedList<Term> l;
	PolynomialAdditionLinkList(){
		l=new LinkedList<Term>();
	}
	public void insert(int coef,int exp){
		Term temp=new Term(coef,exp);
		l.add(temp);
	}
	public LinkedList<Term> add(LinkedList<Term> l1,LinkedList<Term> l2){
		LinkedList<Term> result=new LinkedList<Term>();
		int max=0;
		for(Term t:l1){
			int exp=t.exponent;
			if(exp>max){
				max=exp;
			}
		}
		for(Term t:l2){
			int exp=t.exponent;
			if(exp>max){
				max=exp;
			}
		}
		for(int i=max;i>=0;i--){
			Term t=new Term(0,i);
			result.add(t);
		}
		for(Term t:l1){
			int coef=t.coefficent;
			int exp=t.exponent;
			int index=max-exp;
			Term res=result.get(index);
			int co=res.coefficent;
			int ex=res.exponent;
			int sum=coef+co;
			res.coefficent=sum;
			result.remove(index);
			result.add(index, res);
		}
		for(Term t:l2){
			int coef=t.coefficent;
			int exp=t.exponent;
			int index=max-exp;
			Term res=result.get(index);
			int co=res.coefficent;
			int ex=res.exponent;
			int sum=coef+co;
			res.coefficent=sum;
			result.remove(index);
			result.add(index, res);
		}
		
		return result;

	}
	public void addLink(LinkedList<Term> l1,LinkedList<Term> l2){
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		for(Term t:l1){
			int coeff=t.coefficent;
			int exp=t.exponent;
			if(map.containsKey(exp)){
				int coef=map.get(exp);
				Integer sum=coeff+coef;
				map.put(exp,sum);
			}
			else{
				map.put(exp,coeff);
			}
		}		
		for(Term t:l2){
			int coeff=t.coefficent;
			int exp=t.exponent;
			if(map.containsKey(exp)){
				int coef=map.get(exp);
				Integer sum=coeff+coef;
				map.put(exp,sum);
			}
			else{
				map.put(exp,coeff);
			}
		}
		Iterator it= map.entrySet().iterator();
		while(it.hasNext()){
		Map.Entry<Integer, Integer> entry=(Map.Entry<Integer,Integer>)it.next();
		System.out.println("Exponent "+entry.getKey());
		System.out.println("Coeff "+entry.getValue());
		}
		
	}
	
public static void main(String args[]){
	PolynomialAdditionLinkList p1=new PolynomialAdditionLinkList();
	p1.insert(3,3);
	p1.insert(3,2);
	p1.insert(4,1);
	p1.insert(5,0);
	
	PolynomialAdditionLinkList p2=new PolynomialAdditionLinkList();
	p2.insert(1, 3);
	p2.insert(2,2);
	p2.insert(1,1);
	p2.insert(-4,0);
	
	PolynomialAdditionLinkList p=new PolynomialAdditionLinkList();
	LinkedList<Term> l1=p1.l;
	LinkedList<Term> l2=p2.l;
	LinkedList<Term> l3=p.add(l1, l2);
	for(Term t:l3){
		System.out.println("Coef "+ t.coefficent);
		System.out.println("Exp "+ t.exponent);
		
	}
	
}
}