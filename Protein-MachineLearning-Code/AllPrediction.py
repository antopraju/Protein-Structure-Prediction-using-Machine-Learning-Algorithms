import pickle
import sys


arr1 = sys.argv[1].split('[')
arr2 = arr1[1].split(']')
arr = arr2[0].split(',')
arr_num = [float(num) for num in arr]
test = []
test.append(arr_num)

filename = 'NB_model.sav'
# load the Pre-loaded model from disk
loaded_model = pickle.load(open(filename, 'rb'), encoding='latin1')
preds3 = loaded_model.predict(test)
print(preds3[0])

filename = 'SVM_model.sav'
# load the Pre-loaded model from disk
loaded_model = pickle.load(open(filename, 'rb'), encoding='latin1')
preds3 = loaded_model.predict(test)
print(preds3[0])


filename = 'RF_model.sav'
# load the Pre-loaded model from disk
loaded_model = pickle.load(open(filename, 'rb'), encoding='latin1')
preds3 = loaded_model.predict(test)
print(preds3[0])
