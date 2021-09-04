#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int val;
    struct Node *next;
};

struct Node *head;
int size = 0;

void insert(int num)
{
    struct Node *temp = (struct Node *)malloc(sizeof(struct Node));
    temp->val = num;
    temp->next = head;
    head = temp;
    size++;
}

void insertAt(int num, int pos)
{
    if (pos > size || pos < 0)
    {
        printf("Index out of bounds\n");
        return;
    }
    if (pos == 0)
    {
        insert(num);
    }
    else
    {
        int p = 0;
        struct Node *temp = head;
        struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
        newNode->val = num;
        while (p != pos - 1)
        {
            p++;
            temp = temp->next;
        }
        newNode->next = temp->next;
        temp->next = newNode;
        size++;
    }
}

int remove()
{
    struct Node *ele = head;
    head = head->next;
    size--;
    ele->next = NULL;
    return ele->val;
}

int removeAt(int pos)
{
    if (pos < 0 || pos >= size)
    {
        printf("Index out of bounds\n");
        return NULL;
    }
    if (pos == 0)
        return remove();
    else
    {
        int p = 0;
        struct Node *temp = head;
        while (p != pos - 1)
        {
            p++;
            temp = temp->next;
        }
        struct Node *node = temp->next;
        temp = temp->next->next;
        size--;
        node->next = NULL;
        return temp->val;
    }
}

int find(int ele)
{
    int index = -1;
    int pos = 0;
    struct Node *temp = head;
    while (temp->val != ele)
    {
        temp = temp->next;
        pos++;
    }
    if (temp->val == ele)
        index = pos;
    return index;
}

int get(int pos)
{
    int p = 0;
    struct Node *temp = head;
    while (p != pos)
    {
        p++;
        temp = temp->next;
    }
    return temp->val;
}

void print()
{
    printf("The elements of the array are: ");
    struct Node *temp = head;
    while (temp != NULL)
    {
        printf("%d ", temp->val);
        temp = temp->next;
    }
    printf("\n");
}

int main()
{
    head = NULL;
    int N, i, num;
    printf("Enter the number of elements to be inserted: ");
    scanf("%d", &N);
    for (i = 0; i < N; i++)
    {
        insert(i);
        printf("head: %d\n", head->val);
        print();
    }
    print();
    return 0;
}