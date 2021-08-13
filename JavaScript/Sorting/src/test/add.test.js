const {add,sub}=require('../add');

describe("Sample function", () => {
    test("Addition", () => {
      expect(add(2,3)).toBe(5);
    });
    test("subtraction",()=>{
        expect(sub(5,1)).toBe(4);
    })
  });