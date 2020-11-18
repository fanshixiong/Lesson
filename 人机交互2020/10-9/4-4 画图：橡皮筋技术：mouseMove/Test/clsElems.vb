Public Class clsElems
    Private Elems As List(Of clsElem)

    Public Sub New()
        Elems = New List(Of clsElem)
    End Sub
    Public Sub Append(ByVal Elem As clsElem)
        Elems.Add(Elem)
    End Sub
    Sub Draw(ByVal g As Graphics)
        For i = 0 To Elems.Count - 1
            Elems(i).Draw(g)
        Next
    End Sub
    Sub Display(ByVal lstInfo As ListBox)
        lstInfo.Items.Clear()
        For i = 0 To Elems.Count - 1
            lstInfo.Items.Add(Elems(i).ToString)
        Next
    End Sub

End Class
