function testCase1() {
    assertEquals("testing the addition return Value", addition(2, 3), 5);
}

function testCase2() {
    assertNotEquals("testing the addition return Value", addition(2, 3), 6);
}

function testCase3() {
    assertEquals("testing the addition() returning number", typeof addition(2, 3), "number");
}

function testCase4() {
    assertNotEquals("testing the addition() returning number", typeof addition(2, "3"), "number");
}

function testCase5() {
    assertEquals("testing the addition() is function or not", typeof addition, "function");
}

function assertEquals(description, actual, expected) {
    if (actual === expected)
        return console.log(description + " success!!");
    else
        return console.log(description + " failed!!")
}

function assertNotEquals(description, actual, expected) {
    if (actual != expected)
        return console.log(description + " success!!");
    else
        return console.log(description + " failed!!")
}

function testSuite(params) {
    testCase1();
    testCase2();
    testCase3();
    testCase4();
    testCase5();
}
