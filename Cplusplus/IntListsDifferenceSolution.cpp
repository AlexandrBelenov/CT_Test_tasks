#include <iostream>
#include <list>
#include <algorithm>

using namespace std;

template<class InIter>
void display_list(InIter start, InIter end) {
   InIter itr;
   for(itr = start; itr != end; ++itr)
      cout << *itr << ", ";
}

int main ()
{
  list<int> first = {1, 3, 4, 6, 5, 4};
  list<int> second = {4, 6, 3, 2};
  first.sort();
  second.sort();
  int size = first.size()+second.size();
  list <int> difference(size);
  list<int>::iterator res_end;
  res_end = set_symmetric_difference(first.begin(), first.end(), second.begin(), second.end(), difference.begin());
  display_list(difference.begin(), res_end);
  return 0;
}