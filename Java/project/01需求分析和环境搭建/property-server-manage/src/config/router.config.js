// eslint-disable-next-line
import { UserLayout, BasicLayout, RouteView, BlankLayout, PageView } from '@/layouts'
import { bxAnaalyse } from '@/core/icons'

export const asyncRouterMap = [
    {
        path: '/',
        name: 'index',
        component: BasicLayout,
        meta: { title: '首页' },
        redirect: '/personaloffice/Mynews',
        children: [
            // dashboard
            {
                path: 'personaloffice',
                name: 'personaloffice',
                redirect: '/personaloffice/Mynews',
                component: RouteView,
                meta: { title: '个人办公', keepAlive: true, icon: bxAnaalyse, permission: ['dashboard'] },
                children: [
                    {
                        path: 'Mynews',
                        name: 'Mynews',
                        component: () => import('@/views/personaloffice/Mynews'),
                        meta: { title: '我的消息', keepAlive: true, permission: ['dashboard'] }
                    },
                    {
                        path: 'Mymail',
                        name: 'Mymail',
                        component: () => import('@/views/personaloffice/Mymail'),
                        meta: { title: '我的邮件', keepAlive: true, permission: ['dashboard'] }
                    }
                ]
            },
            {
                path: 'property',
                name: 'property',
                component: PageView,
                meta: { title: '楼盘管理', icon: 'slack', permission: ['dashboard'] },
                redirect: '/property/add',
                children: [
                    {
                        path: '/property/add',
                        component: RouteView,
                        meta: { title: '住宅小区', icon: 'layout', permission: ['dashboard'] },
                        redirect: '/property/add',
                        children: [
                            {
                                path: '/property/add',
                                name: '新增住宅向导',
                                component: () => import('@/views/property/add'),
                                meta: { title: '新增住宅向导', keepAlive: true }
                            },
                            {
                                path: '/property/building',
                                name: '批量增加住宅',
                                component: () => import('@/views/property/building'),
                                meta: { title: '批量增加楼宇', keepAlive: true }
                            },
                            {
                                path: '/property/maintain',
                                name: '住宅维护',
                                component: () => import('@/views/property/maintain'),
                                meta: {
                                    title: '住宅维护',
                                    keepAlive: true
                                }
                            },
                            {
                                path: '/property/search',
                                name: '住宅查询',
                                component: () => import('@/views/property/search'),
                                meta: { title: '住宅查询', keepAlive: true }
                            }
                        ]
                    },
                    {
                        path: '/business/add',
                        component: RouteView,
                        meta: { title: '商业房产', icon: 'layout', permission: ['dashboard'] },
                        redirect: '/business/add',
                        children: [
                            {
                                path: '/business/add',
                                name: '新增房产向导',
                                component: () => import('@/views/business/add'),
                                meta: { title: '新增房产向导', keepAlive: true }
                            },
                            {
                                path: '/business/building',
                                name: '批量增加商业房产',
                                component: () => import('@/views/business/building'),
                                meta: { title: '批量增加楼宇', keepAlive: true }
                            },
                            {
                                path: '/business/maintain',
                                name: '房产维护',
                                component: () => import('@/views/business/maintain'),
                                meta: { title: '住宅维护', keepAlive: true }
                            },
                            {
                                path: '/business/search',
                                name: '房产查询',
                                component: () => import('@/views/business/search'),
                                meta: { title: '住宅查询', keepAlive: true }
                            }
                        ]
                    }
                ]
            },
            {
                path: 'owner',
                component: RouteView,
                meta: { title: '业主信息', icon: bxAnaalyse, permission: ['dashboard'] },
                redirect: '/owner/information',
                children: [
                    {
                        path: 'information',
                        name: 'information',
                        component: () => import('@/views/owner/information'),
                        meta: { title: '业主信息', keepAlive: true, permission: ['dashboard'] }
                    },
                    {
                        path: 'inspection',
                        name: 'inspection',
                        component: () => import('@/views/owner/inspection'),
                        meta: { title: '业主验房', keepAlive: true, permission: ['dashboard'] }
                    },
                    {
                        path: '/owner/decoration/enter',
                        component: RouteView,
                        meta: { title: '业主装修', keepAlive: true, permission: ['dashboard'] },
                        redirect: '/owner/decoration/enter',
                        children: [
                            {
                                path: '/owner/decoration/enter',
                                name: '装修录入',
                                component: () => import('@/views/owner/decoration/enter'),
                                meta: { title: '装修录入', keepAlive: true }
                            },
                            {
                                path: '/owner/decoration/approval',
                                name: '装修审批',
                                component: () => import('@/views/owner/decoration/approval'),
                                meta: { title: '装修审批', keepAlive: true }
                            },
                            {
                                path: '/owner/decoration/invalid',
                                name: '装修作废',
                                component: () => import('@/views/owner/decoration/invalid'),
                                meta: { title: '装修作废', keepAlive: true }
                            },
                            {
                                path: '/owner/decoration/acceptance',
                                name: '装修验收',
                                component: () => import('@/views/owner/decoration/acceptance'),
                                meta: { title: '装修验收', keepAlive: true }
                            },
                            {
                                path: '/owner/decoration/search',
                                name: '装修查询',
                                component: () => import('@/views/owner/decoration/search'),
                                meta: { title: '装修查询', keepAlive: true }
                            }
                        ]
                    },
                    {
                        path: 'checkin',
                        name: 'checkin',
                        component: () => import('@/views/owner/checkin'),
                        meta: { title: '业主入住', keepAlive: true, permission: ['dashboard'] }
                    },
                    {
                        path: 'complaint',
                        name: 'complaint',
                        component: () => import('@/views/owner/complaint'),
                        meta: { title: '业主投诉', keepAlive: true, permission: ['dashboard'] }
                    },
                    {
                        path: 'management',
                        name: 'management',
                        component: () => import('@/views/owner/management'),
                        meta: { title: '请修管理', keepAlive: true, permission: ['dashboard'] }
                    },
                    {
                        path: 'addition',
                        name: 'addition',
                        component: () => import('@/views/owner/addition'),
                        meta: { title: '业主加建', keepAlive: true, permission: ['dashboard'] }
                    }
                ]
            },
            {
                path: '/cost/common',
                component: RouteView,
                meta: { title: '费项设置', icon: bxAnaalyse, permission: ['dashboard'] },
                redirect: '/cost/common',
                children: [
                    {
                        path: '/cost/common/enactment',
                        component: RouteView,
                        meta: { title: '常规费项', keepAlive: true, permission: ['dashboard'] },
                        redirect: '/cost/common/enactment',
                        children: [
                            {
                                path: '/cost/common/enactment',
                                name: '常规费项设定',
                                component: () => import('@/views/cost/common/enactment'),
                                meta: { title: '费项设定', keepAlive: true }
                            },
                            {
                                path: '/cost/common/distributed',
                                name: '费项分布',
                                component: () => import('@/views/cost/common/distributed'),
                                meta: { title: '费项分布', keepAlive: true }
                            },
                            {
                                path: '/cost/common/initialization',
                                name: '初始化仪表',
                                component: () => import('@/views/cost/common/initialization'),
                                meta: { title: '初始化仪表', keepAlive: true }
                            },
                            {
                                //   floorcoefficient
                                path: '/cost/common/floorcoefficient',
                                name: '楼层系数',
                                component: () => import('@/views/cost/common/floorcoefficient'),
                                meta: { title: '楼层系数', keepAlive: true }
                            }
                        ]
                    },
                    {
                        path: '/cost/pool/enactment',
                        component: RouteView,
                        meta: { title: '公摊费项', keepAlive: true, permission: ['dashboard'] },
                        redirect: '/cost/pool/enactment',
                        children: [
                            {
                                path: '/cost/pool/enactment',
                                name: '公摊费项设定',
                                component: () => import('@/views/cost/pool/enactment'),
                                meta: { title: '费项设定', keepAlive: true }
                            },
                            {
                                path: '/cost/pool/publicassessment',
                                name: '公摊费分布',
                                component: () => import('@/views/cost/pool/publicassessment'),
                                meta: { title: '公摊费分布', keepAlive: true }
                            }
                        ]
                    },
                    {
                        //  serviceteam  printdocuments
                        path: '/cost/convenient',
                        name: 'convenient',
                        component: () => import('@/views/cost/convenient'),
                        meta: { title: '便捷费项', keepAlive: true, permission: ['dashboard'] }
                    },
                    {
                        path: '/cost/casualguest',
                        name: 'casualguest',
                        component: () => import('@/views/cost/convenient'),
                        meta: { title: '便捷费项', keepAlive: true, permission: ['dashboard'] }
                    },
                    {
                        path: '/cost/serviceteam',
                        name: 'serviceteam',
                        component: () => import('@/views/cost/serviceteam'),
                        meta: { title: '客服组设置', keepAlive: true, permission: ['dashboard'] }
                    },
                    {
                        path: '/cost/printdocuments',
                        name: 'printdocuments',
                        component: () => import('@/views/cost/printdocuments'),
                        meta: { title: '打印单据设定', keepAlive: true, permission: ['dashboard'] }
                    }
                ]
            },
            {
                path: 'dashboard',
                name: 'dashboard',
                redirect: '/dashboard/workplace',
                component: RouteView,
                meta: { title: 'demo仪表盘', keepAlive: true, icon: bxAnaalyse, permission: ['dashboard'] },
                children: [
                    {
                        path: 'analysis/:pageNo([1-9]\\d*)?',
                        name: 'Analysis',
                        component: () => import('@/views/dashboard/Analysis'),
                        meta: { title: '分析页', keepAlive: false, permission: ['dashboard'] }
                    },
                    {
                        path: 'workplace',
                        name: 'Workplace',
                        component: () => import('@/views/dashboard/Workplace'),
                        meta: { title: '工作台', keepAlive: true, permission: ['dashboard'] }
                    },
                    {
                        path: 'test-work',
                        name: 'TestWork',
                        component: () => import('@/views/dashboard/TestWork'),
                        meta: { title: '测试功能', keepAlive: true, permission: ['dashboard'] }
                    }
                ]
            },
            // forms
            {
                path: '/form',
                redirect: '/form/base-form',
                component: PageView,
                meta: { title: 'demo表单页', icon: 'form', permission: ['form'] },
                children: [
                    {
                        path: '/form/base-form',
                        name: 'BaseForm',
                        component: () => import('@/views/form/BasicForm'),
                        meta: { title: '基础表单', keepAlive: true, permission: ['form'] }
                    },
                    {
                        path: '/form/step-form',
                        name: 'StepForm',
                        component: () => import('@/views/form/stepForm/StepForm'),
                        meta: { title: '分步表单', keepAlive: true, permission: ['form'] }
                    },
                    {
                        path: '/form/advanced-form',
                        name: 'AdvanceForm',
                        component: () => import('@/views/form/advancedForm/AdvancedForm'),
                        meta: { title: '高级表单', keepAlive: true, permission: ['form'] }
                    }
                ]
            },

            // list
            {
                path: '/list',
                name: 'list',
                component: PageView,
                redirect: '/list/table-list',
                meta: { title: 'demo列表页', icon: 'table', permission: ['table'] },
                children: [
                    {
                        path: '/list/table-list/:pageNo([1-9]\\d*)?',
                        name: 'TableListWrapper',
                        hideChildrenInMenu: true, // 强制显示 MenuItem 而不是 SubMenu
                        component: () => import('@/views/list/TableList'),
                        meta: { title: '查询表格', keepAlive: true, permission: ['table'] }
                    },
                    {
                        path: '/list/basic-list',
                        name: 'BasicList',
                        component: () => import('@/views/list/StandardList'),
                        meta: { title: '标准列表', keepAlive: true, permission: ['table'] }
                    },
                    {
                        path: '/list/card',
                        name: 'CardList',
                        component: () => import('@/views/list/CardList'),
                        meta: { title: '卡片列表', keepAlive: true, permission: ['table'] }
                    },
                    {
                        path: '/list/search',
                        name: 'SearchList',
                        component: () => import('@/views/list/search/SearchLayout'),
                        redirect: '/list/search/article',
                        meta: { title: '搜索列表', keepAlive: true, permission: ['table'] },
                        children: [
                            {
                                path: '/list/search/article',
                                name: 'SearchArticles',
                                component: () => import('../views/list/search/Article'),
                                meta: { title: '搜索列表（文章）', permission: ['table'] }
                            },
                            {
                                path: '/list/search/project',
                                name: 'SearchProjects',
                                component: () => import('../views/list/search/Projects'),
                                meta: { title: '搜索列表（项目）', permission: ['table'] }
                            },
                            {
                                path: '/list/search/application',
                                name: 'SearchApplications',
                                component: () => import('../views/list/search/Applications'),
                                meta: { title: '搜索列表（应用）', permission: ['table'] }
                            }
                        ]
                    }
                ]
            },

            // profile
            {
                path: '/profile',
                name: 'profile',
                component: RouteView,
                redirect: '/profile/basic',
                meta: { title: 'demo详情页', icon: 'profile', permission: ['profile'] },
                children: [
                    {
                        path: '/profile/basic',
                        name: 'ProfileBasic',
                        component: () => import('@/views/profile/basic/Index'),
                        meta: { title: '基础详情页', permission: ['profile'] }
                    },
                    {
                        path: '/profile/advanced',
                        name: 'ProfileAdvanced',
                        component: () => import('@/views/profile/advanced/Advanced'),
                        meta: { title: '高级详情页', permission: ['profile'] }
                    }
                ]
            },

            // result
            {
                path: '/result',
                name: 'result',
                component: PageView,
                redirect: '/result/success',
                meta: { title: 'demo结果页', icon: 'check-circle-o', permission: ['result'] },
                children: [
                    {
                        path: '/result/success',
                        name: 'ResultSuccess',
                        component: () => import(/* webpackChunkName: "result" */ '@/views/result/Success'),
                        meta: { title: '成功', keepAlive: false, hiddenHeaderContent: true, permission: ['result'] }
                    },
                    {
                        path: '/result/fail',
                        name: 'ResultFail',
                        component: () => import(/* webpackChunkName: "result" */ '@/views/result/Error'),
                        meta: { title: '失败', keepAlive: false, hiddenHeaderContent: true, permission: ['result'] }
                    }
                ]
            },

            // Exception
            {
                path: '/exception',
                name: 'exception',
                component: RouteView,
                redirect: '/exception/403',
                meta: { title: 'demo异常页', icon: 'warning', permission: ['exception'] },
                children: [
                    {
                        path: '/exception/403',
                        name: 'Exception403',
                        component: () => import(/* webpackChunkName: "fail" */ '@/views/exception/403'),
                        meta: { title: '403', permission: ['exception'] }
                    },
                    {
                        path: '/exception/404',
                        name: 'Exception404',
                        component: () => import(/* webpackChunkName: "fail" */ '@/views/exception/404'),
                        meta: { title: '404', permission: ['exception'] }
                    },
                    {
                        path: '/exception/500',
                        name: 'Exception500',
                        component: () => import(/* webpackChunkName: "fail" */ '@/views/exception/500'),
                        meta: { title: '500', permission: ['exception'] }
                    }
                ]
            },

            // account
            {
                path: '/account',
                component: RouteView,
                redirect: '/account/center',
                name: 'account',
                meta: { title: 'demo个人页', icon: 'user', keepAlive: true, permission: ['user'] },
                children: [
                    {
                        path: '/account/center',
                        name: 'center',
                        component: () => import('@/views/account/center/Index'),
                        meta: { title: '个人中心', keepAlive: true, permission: ['user'] }
                    },
                    {
                        path: '/account/settings',
                        name: 'settings',
                        component: () => import('@/views/account/settings/Index'),
                        meta: { title: '个人设置', hideHeader: true, permission: ['user'] },
                        redirect: '/account/settings/base',
                        hideChildrenInMenu: true,
                        children: [
                            {
                                path: '/account/settings/base',
                                name: 'BaseSettings',
                                component: () => import('@/views/account/settings/BaseSetting'),
                                meta: { title: '基本设置', hidden: true, permission: ['user'] }
                            },
                            {
                                path: '/account/settings/security',
                                name: 'SecuritySettings',
                                component: () => import('@/views/account/settings/Security'),
                                meta: { title: '安全设置', hidden: true, keepAlive: true, permission: ['user'] }
                            },
                            {
                                path: '/account/settings/custom',
                                name: 'CustomSettings',
                                component: () => import('@/views/account/settings/Custom'),
                                meta: { title: '个性化设置', hidden: true, keepAlive: true, permission: ['user'] }
                            },
                            {
                                path: '/account/settings/binding',
                                name: 'BindingSettings',
                                component: () => import('@/views/account/settings/Binding'),
                                meta: { title: '账户绑定', hidden: true, keepAlive: true, permission: ['user'] }
                            },
                            {
                                path: '/account/settings/notification',
                                name: 'NotificationSettings',
                                component: () => import('@/views/account/settings/Notification'),
                                meta: { title: '新消息通知', hidden: true, keepAlive: true, permission: ['user'] }
                            }
                        ]
                    }
                ]
            },

            // other
            {
                path: '/other',
                name: 'otherPage',
                component: PageView,
                meta: { title: 'demo其他组件', icon: 'slack', permission: ['dashboard'] },
                redirect: '/other/icon-selector',
                children: [
                    {
                        path: '/other/icon-selector',
                        name: 'TestIconSelect',
                        component: () => import('@/views/other/IconSelectorView'),
                        meta: { title: 'IconSelector', icon: 'tool', keepAlive: true, permission: ['dashboard'] }
                    },
                    {
                        path: '/other/list',
                        component: RouteView,
                        meta: { title: '业务布局', icon: 'layout', permission: ['support'] },
                        redirect: '/other/list/tree-list',
                        children: [
                            {
                                path: '/other/list/tree-list',
                                name: 'TreeList',
                                component: () => import('@/views/other/TreeList'),
                                meta: { title: '树目录表格', keepAlive: true }
                            },
                            {
                                path: '/other/list/edit-table',
                                name: 'EditList',
                                component: () => import('@/views/other/TableInnerEditList'),
                                meta: { title: '内联编辑表格', keepAlive: true }
                            },
                            {
                                path: '/other/list/user-list',
                                name: 'UserList',
                                component: () => import('@/views/other/UserList'),
                                meta: { title: '用户列表', keepAlive: true }
                            },
                            {
                                path: '/other/list/role-list',
                                name: 'RoleList',
                                component: () => import('@/views/other/RoleList'),
                                meta: { title: '角色列表', keepAlive: true }
                            },
                            {
                                path: '/other/list/system-role',
                                name: 'SystemRole',
                                component: () => import('@/views/role/RoleList'),
                                meta: { title: '角色列表2', keepAlive: true }
                            },
                            {
                                path: '/other/list/permission-list',
                                name: 'PermissionList',
                                component: () => import('@/views/other/PermissionList'),
                                meta: { title: '权限列表', keepAlive: true }
                            }
                        ]
                    }
                ]
            }
        ]
    },
    {
        path: '*',
        redirect: '/404',
        hidden: true
    }
]

/**
 * 基础路由
 * @type { *[] }
 */
export const constantRouterMap = [
    {
        path: '/user',
        component: UserLayout,
        redirect: '/user/login',
        hidden: true,
        children: [
            {
                path: 'login',
                name: 'login',
                component: () => import(/* webpackChunkName: "user" */ '@/views/user/Login')
            },
            {
                path: 'register',
                name: 'register',
                component: () => import(/* webpackChunkName: "user" */ '@/views/user/Register')
            },
            {
                path: 'register-result',
                name: 'registerResult',
                component: () => import(/* webpackChunkName: "user" */ '@/views/user/RegisterResult')
            },
            {
                path: 'recover',
                name: 'recover',
                component: undefined
            }
        ]
    },

    {
        path: '/test',
        component: BlankLayout,
        redirect: '/test/home',
        children: [
            {
                path: 'home',
                name: 'TestHome',
                component: () => import('@/views/Home')
            }
        ]
    },

    {
        path: '/404',
        component: () => import(/* webpackChunkName: "fail" */ '@/views/exception/404')
    }
]
