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
	{ 0x3e230885, "single_release" },
	{ 0xfee7c6cb, "seq_read" },
	{ 0x1f433b7d, "seq_lseek" },
	{ 0xb7a8281, "remove_proc_entry" },
	{ 0xc5850110, "printk" },
	{ 0x4c684ef, "proc_create" },
	{ 0xe9a8fe46, "seq_printf" },
	{ 0x15ba50a6, "jiffies" },
	{ 0x9875a8e1, "single_open" },
	{ 0xbdfb6dbb, "__fentry__" },
};

MODULE_INFO(depends, "");


MODULE_INFO(srcversion, "7DD6ECBBE12583D679ED654");
