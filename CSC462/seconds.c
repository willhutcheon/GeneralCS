#include <linux/module.h>
#include <linux/proc_fs.h>
#include <linux/uaccess.h>
#include <linux/jiffies.h>
#include <linux/seq_file.h>

#define PROC_NAME "seconds"

static unsigned long start_jiffies;

static int proc_show(struct seq_file *m, void *v)
{
	unsigned long elapsed_jiffies = jiffies - start_jiffies;
	unsigned long elapsed_seconds = elapsed_jiffies / HZ;
	seq_printf(m, "%lu\n", elapsed_seconds);
	return 0;
}
static int proc_open(struct inode *inode, struct file *file)
{
	return single_open(file, proc_show, NULL);
}
static const struct file_operations proc_fops = {
	.owner = THIS_MODULE,
	.open = proc_open,
	.read = seq_read,
	.llseek = seq_lseek,
	.release = single_release,
};
static int __init seconds_init(void)
{
	start_jiffies = jiffies;
	proc_create(PROC_NAME, 0, NULL, &proc_fops);
	printk(KERN_INFO "/proc/%s created\n", PROC_NAME);
	return 0;
}
static void __exit seconds_exit(void)
{
	remove_proc_entry(PROC_NAME, NULL);
	printk(KERN_INFO "/proc/%s removed\n", PROC_NAME);
}

MODULE_LICENSE("GPL");
MODULE_AUTHOR("Will Hutcheon");
MODULE_DESCRIPTION("/proc/seconds module");
MODULE_VERSION("1.0");

module_init(seconds_init);
module_exit(seconds_exit);
