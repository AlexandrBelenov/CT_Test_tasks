const first = [1, 3, 3, 4, 6, 5, 4];
const second = [6, 3, 5, 2, 2];

// Implement a logic that finds difference between "first" and "secord" lists
// and prints the result to the console:
// [1, 2, 4]

const merged = [...first, ...second];
let difference = [...new Set(merged)];
difference = difference.filter(element => {
    return !(first.includes(element) && second.includes(element))
});
difference.sort();
console.log(difference);