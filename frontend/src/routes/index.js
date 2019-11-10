import VueRouter from "vue-router";

import EmployeeList from "../components/adminEmployee/EmployeeList";
import EmployeeAdd from "../components/adminEmployee/EmployeeAdd";
import EmployeeEdit from "../components/adminEmployee/EmployeeEdit";
import EmployeeReview from "../components/employee/EmployeeReview";
import AdminEmployeeReview from "../components/adminEmployeeReview/AdminEmployeeReview";

export default new VueRouter({
    mode: "history",
    routes: [
        {
            path: '',
            name: 'default',
            component: EmployeeReview
        },
        {
            path: '/admin/employee',
            name: 'adminEmployee',
            component: EmployeeList
        },
        {
            path: '/admin/employee/new',
            name: 'adminEmployeeNew',
            component: EmployeeAdd
        },
        {
            path: '/admin/employee/:id',
            name: 'adminEmployeeEdit',
            component: EmployeeEdit
        },
        {
            path: '/employeeReview',
            name: 'employeeReview',
            component: EmployeeReview
        },
        {
            path: '/admin/employeeReview',
            name: 'adminEmployeeReview',
            component: AdminEmployeeReview
        },
    ]
})
