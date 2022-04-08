using System;
using System.Linq;
using System.Collections.Generic;

namespace intLists
{
    class IntListsDifferenceSolution
    {
        public static void Main()
	{
		var first = new List<int> {1, 3, 3, 4, 6, 5, 4};
		var second = new List<int> {6, 3, 5, 2, 2};

        //main task
        //Implement a logic that finds difference between "first" and "secord" lists
        // and prints the result to the console:
        // [1, 2, 4]
        //enhanced task
        //** try to come up with solution wich doesn't use set data structure
		var diff = first.Union(second).Except(first.Intersect(second));
		Console.WriteLine(String.Join(", ", diff));
	}
    }
}
