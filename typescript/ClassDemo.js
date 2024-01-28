var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var Human = /** @class */ (function () {
    function Human(name, age) {
        this.name = name;
        this.age = age;
        console.log('Human constructor');
    }
    Human.prototype.display = function () {
        console.log('Name ', this.name, ' Age ', this.age);
    };
    return Human;
}());
var Teacher = /** @class */ (function (_super) {
    __extends(Teacher, _super);
    function Teacher(name, age, school) {
        var _this = _super.call(this, name, age) || this;
        _this.school = school;
        return _this;
    }
    Teacher.prototype.display = function () {
        _super.prototype.display.call(this);
        console.log("School ", this.school);
    };
    return Teacher;
}(Human));
/*
let h: Human = new Human('Tk',39);
h.display();
*/
var h = new Teacher('Tk', 39, 'Turing');
h.display();
