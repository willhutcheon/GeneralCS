#include <linux/init.h>
#include <linux/module.h>
#include <linux/module.h>
#include <linux/proc_fs.h>
#include <linux/uaccess.h>
#include <linux/jiffies.h>
#include <linux/seq_file.h>

#define PROC_NAME "jiffies"

static int jiffies_proc_show(struct seq_file *m, void *v)
{
	seq_printf(m, "%lu\n", jiffies);
	return 0;
}
static int jiffies_proc_open(struct inode *inode, struct file *file)
{
	return single_open(file, jiffies_proc_show, NULL);
}
static const struct file_operations proc_file_fops = {
	.owner = THIS_MODULE,
	.open = jiffies_proc_open,
	.read = seq_read,
	.llseek = seq_lseek,
	.release = single_release,
};
static int __init jiffies_module_init(void)
{
	proc_create(PROC_NAME, 0, NULL, &proc_file_fops);
	printk(KERN_INFO "/proc/%s created\n", PROC_NAME);
	return 0;
}
static void __exit jiffies_module_exit(void)
{
	remove_proc_entry(PROC_NAME, NULL);
	printk(KERN_INFO "/proc/%s removed\n", PROC_NAME);
}
module_init(jiffies_module_init);
module_exit(jiffies_module_exit);

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Will Hutcheon");
MODULE_DESCRIPTION("Jiffies");
