#include <linux/build-salt.h>
#include <linux/module.h>
#include <linux/vermagic.h>
#include <linux/compiler.h>

BUILD_SALT;

MODULE_INFO(vermagic, VERMAGIC_STRING);
MODULE_INFO(name, KBUILD_MODNAME);

__visible struct module __this_module
__section(.gnu.linkonce.this_module) = {
	.name = KBUILD_MODNAME,
	.init = init_module,
#ifdef CONFIG_MODULE_UNLOAD
	.exit = cleanup_module,
#endif
	.arch = MODULE_ARCH_INIT,
};

#ifdef CONFIG_RETPOLINE
MODULE_INFO(retpoline, "Y");
#endif

static const struct modversion_info ____versions[]
__used __section(__versions) = {
	{ 0xc79d2779, "module_layout" },
	{ 0xb7a8281, "remove_proc_entry" },
	{ 0x4c684ef, "proc_create" },
	{ 0xdecd0b29, "__stack_chk_fail" },
	{ 0x56470118, "__warn_printk" },
	{ 0xb44ad4b3, "_copy_to_user" },
	{ 0x656e4a6e, "snprintf" },
	{ 0xb59a948b, "pid_task" },
	{ 0x2746d283, "find_vpid" },
	{ 0xc5850110, "printk" },
	{ 0x37a0cba, "kfree" },
	{ 0x779a18af, "kstrtoll" },
	{ 0x362ef408, "_copy_from_user" },
	{ 0x88db9f48, "__check_object_size" },
	{ 0xeb233a45, "__kmalloc" },
	{ 0xbdfb6dbb, "__fentry__" },
};

MODULE_INFO(depends, "");


MODULE_INFO(srcversion, "C796D40F8D3F9D756B40571");
